import React from "react";
import { toast } from "react-toastify";
import { useForm} from "react-hook-form";
import { prefixOptions, vehicleBodyTypeOptions, engineSizeOptions } from "./SelectOptions";
import moment from 'moment';
import {
  Container,
  Divider,
  Flex,
  VStack,
  Heading,
  Text,
  SimpleGrid,
  GridItem,
  FormControl,
  FormLabel,
  FormErrorMessage,
  Button,
  useBreakpointValue,
} from "@chakra-ui/react";
import axios from "axios";
import { useHistory } from "react-router-dom";
import {
  validationAdditionalDrivers,
  validationCurrentValue,
  validationFirstName,
  validationLastName,
  validationRequiredField,
  validationTelephoneNumber
} from "../ValidationOptions";
import { InputFieldController } from "../FormComponents/InputFieldController";
import { SelectController } from "../FormComponents/SelectController";
import { NumberInputFieldController } from "../FormComponents/NumberInputFieldController";
import { RadioController } from "../FormComponents/RadioController";
import { DatePickerController } from "../FormComponents/DatePickerController";

export default function QuoteForm() {
  const {
    handleSubmit,
    control,
    formState: { errors },
  } = useForm({
    mode: "onBlur",
  });

  const colSpan1 = useBreakpointValue({ base: 6, md: 2 });
  const colSpan2 = useBreakpointValue({ base: 6, md: 3 });
  const history = useHistory();

  const handleRegistration = (data) => {
    const url = "/api/drivers";
    axios
      .post(url, data)
      .then((response) => {
        let id = response.data.id;
        if (response.status >= 200 && response.status < 300){
          toast.success("Thanks, your quote has been submitted!", {
            onClose: () => history.push(`/driver-details/${id}`),
          })
        }
      })
      .catch(function () {
        toast.error("Oops, something went wrong!")
      });
  };

  const handleError = (errors) => {
    console.log(errors);
  };

  return (
    <Container maxWidth="container.xl" padding={0}>
      <Flex
        bgColor="grey.400"
        h={{ base: "auto", md: "full" }}
        py={[5, 10]}
        direction={{ base: "column-reverse", md: "row" }}
      >
        <VStack w="full" h="full" px={5} spacing={10} alignItems="center">
          <VStack spacing={3} alignItems="center">
            <Heading size="2xl">Get Quote</Heading>
            <Text>Please enter your driver details below to get a quote.</Text>
          </VStack>

          <form onSubmit={handleSubmit(handleRegistration, handleError)}>
            <SimpleGrid
              padding={[5, 10]}
              bgColor="grey.200"
              columns={6}
              columnGap={3}
              rowGap={6}
              w="full"
            >
              <GridItem colSpan={6} mb={3}>
                <Heading size="lg">About You...</Heading>
                <Divider/>
              </GridItem>
              <GridItem colSpan={colSpan1}>
                <FormControl isRequired isInvalid={errors.prefix}>
                  <FormLabel htmlFor="prefix">Prefix</FormLabel>
                  <SelectController
                      className={"select"}
                      id={"prefix"}
                      name={"prefix"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      isInvalid={errors.prefix}
                      options={prefixOptions}
                      placeholder={"Select..."}
                  />
                  <FormErrorMessage>
                    {errors.prefix && errors.prefix.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan1}>
                <FormControl isRequired isInvalid={errors.firstName}>
                  <FormLabel htmlFor="firstName">First Name</FormLabel>
                  <InputFieldController
                      id={"firstName"}
                      name={"firstName"}
                      control={control}
                      defaultValue={""}
                      rules={validationFirstName}
                      type={"text"}
                      placeholder={"Please Enter First Name"}
                  />
                  <FormErrorMessage>
                    {errors.firstName && errors.firstName.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan1}>
                <FormControl isRequired isInvalid={errors.lastName}>
                  <FormLabel htmlFor="lastName">Last Name</FormLabel>
                  <InputFieldController
                      id={"lastName"}
                      name={"lastName"}
                      control={control}
                      defaultValue={""}
                      rules={validationLastName}
                      type={"text"}
                      placeholder={"Please Enter Last Name"}
                  />
                  <FormErrorMessage>
                    {errors.lastName && errors.lastName.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>

              <GridItem colSpan={6}>
                <FormControl isRequired isInvalid={errors.telephoneNumber}>
                  <FormLabel htmlFor="telephoneNumber">
                    Telephone Number
                  </FormLabel>
                  <InputFieldController
                      id={"telephoneNumber"}
                      name={"telephoneNumber"}
                      control={control}
                      defaultValue={""}
                      rules={validationTelephoneNumber}
                      type={"tel"}
                      placeholder={"Please Enter Tel..."}
                  />
                  <FormErrorMessage>
                    {errors.telephoneNumber && errors.telephoneNumber.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={6}>
                <FormControl isRequired isInvalid={errors.addressLine1}>
                  <FormLabel htmlFor="addressLine1">
                    Address Line 1 (Street)
                  </FormLabel>
                  <InputFieldController
                      id={"addressLine1"}
                      name={"addressLine1"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      type={"text"}
                      placeholder={"Please Enter Address Line 1 (Street)..."}
                  />
                  <FormErrorMessage>
                    {errors.addressLine1 && errors.addressLine1.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={6}>
                <FormControl isRequired isInvalid={errors.addressLine2}>
                  <FormLabel htmlFor="addressLine2">
                    Address Line 2 (Road)
                  </FormLabel>
                  <InputFieldController
                      id={"addressLine2"}
                      name={"addressLine2"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      type={"text"}
                      placeholder={"Please Enter Address Line 2 (Road)..."}
                  />
                  <FormErrorMessage>
                    {errors.addressLine2 && errors.addressLine2.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.city}>
                  <FormLabel htmlFor="city">City</FormLabel>
                  <InputFieldController
                      id={"city"}
                      name={"city"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      type={"text"}
                      placeholder={"Please Enter City..."}
                  />
                  <FormErrorMessage>
                    {errors.city && errors.city.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.postcode}>
                  <FormLabel htmlFor="postcode">Postcode / Zip</FormLabel>
                  <InputFieldController
                      id={"postcode"}
                      name={"postcode"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      type={"text"}
                      placeholder={"Please Enter Postcode / Zip..."}
                  />
                  <FormErrorMessage>
                    {errors.postcode && errors.postcode.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={6} my={3}>
                <Heading size="lg">About Your Vehicle...</Heading>
                <Divider/>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.vehicleBodyType}>
                  <FormLabel htmlFor="vehicleBodyType">Vehicle Type</FormLabel>
                  <SelectController
                      className={"select"}
                      id={"vehicleBodyType"}
                      name={"vehicleBodyType"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      isInvalid={errors.vehicleBodyType}
                      options={vehicleBodyTypeOptions}
                      placeholder={"Select..."}
                  />
                  <FormErrorMessage>
                    {errors.vehicleBodyType && errors.vehicleBodyType.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.engineSize}>
                  <FormLabel htmlFor="engineSize">Engine Size</FormLabel>
                  <SelectController
                      className={"select"}
                      id={"engineSize"}
                      name={"engineSize"}
                      control={control}
                      defaultValue={""}
                      rules={validationRequiredField}
                      isInvalid={errors.engineSize}
                      options={engineSizeOptions}
                      placeholder={"Select..."}
                  />
                  <FormErrorMessage>
                    {errors.engineSize && errors.engineSize.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={6}>
                <FormControl isRequired isInvalid={errors.additionalDrivers}>
                  <FormLabel htmlFor="additionalDrivers">
                    Additional Drivers
                  </FormLabel>
                  <NumberInputFieldController
                      id={"additionalDrivers"}
                      name={"additionalDrivers"}
                      control={control}
                      defaultValue={1}
                      rules={validationAdditionalDrivers}
                      minValue={0}
                      maxValue={4}
                      precision={0}
                      clampValueOnBlur={false}
                  />
                  <FormErrorMessage>
                    {errors.additionalDrivers &&
                      errors.additionalDrivers.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.commercialUse}>
                  <FormLabel htmlFor="commercialUse">
                    Will the vehicle be used for commercial purposes?
                  </FormLabel>
                    <RadioController
                        isInvalid = {errors.commercialUse}
                        id={"commercialUse"}
                        name={"commercialUse"}
                        control={control}
                        defaultValue={""}
                        rules={validationRequiredField}
                    />
                  <FormErrorMessage>
                    {errors.commercialUse &&
                      errors.commercialUse.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.outsideStateUse}>
                  <FormLabel htmlFor="outsideStateUse">
                    Will the vehicle be used out of the registered state?
                  </FormLabel>
                    <RadioController isRequired
                        id={"outsideStateUse"}
                        name={"outsideStateUse"}
                        control={control}
                        defaultValue={""}
                        rules={validationRequiredField}
                    />
                  <FormErrorMessage>
                    {errors.outsideStateUse &&
                      errors.outsideStateUse.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.currentValue}>
                  <FormLabel htmlFor="currentValue">
                    What is the current value ($0-$50,000)?
                  </FormLabel>
                  <NumberInputFieldController
                      id={"currentValue"}
                      name={"currentValue"}
                      control={control}
                      defaultValue={0}
                      rules={validationCurrentValue}
                      minValue={0}
                      maxValue={50000}
                      precision={2}
                      clampValueOnBlur={false}
                  />
                  <FormErrorMessage>
                    {errors.currentValue && errors.currentValue.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl
                  className="light-theme"
                  isRequired
                  isInvalid={errors.dateRegistered}
                >
                  <FormLabel htmlFor="dateRegistered">
                    Date vehicle was first registered?
                  </FormLabel>
                  <DatePickerController
                      className={"react-datepicker__input-text"}
                      id={"dateRegistered"}
                      name={"dateRegistered"}
                      control={control}
                      defaultValue={new Date()}
                      rules={validationRequiredField}
                      dateFormat={"dd/MM/yyyy"}
                      filterDate={(date) => {
                        return moment() > date;}}
                  />
                  <FormErrorMessage>
                    {errors.dateRegistered && errors.dateRegistered.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={6}>
                <Button type="submit" size="lg" w="50%" my={5}>
                  Submit
                </Button>
              </GridItem>
            </SimpleGrid>
          </form>
        </VStack>
      </Flex>
    </Container>
  );
}
