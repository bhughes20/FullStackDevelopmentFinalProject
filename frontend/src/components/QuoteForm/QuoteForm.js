import React from "react";
import { toast } from "react-toastify";
import { useForm} from "react-hook-form";
import { prefixOptions, vehicleBodyTypeOptions, engineSizeOptions } from "./SelectOptions";
import moment from 'moment';
import {
  Container,
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
  validationAdditionalDrivers, validationCurrentValue,
  validationFirstName,
  validationLastName,
  validationRequiredField,
  validationTelephoneNumber
} from "../ValidationOptions";
import { InputFieldController } from "../FormComponents/InputFieldController";
import { SelectController } from "../FormComponents/SelectController";
import { NumberInputFieldController } from "../FormComponents/NumberInputFieldController";
import { RadioInputField } from "../FormComponents/RadioInputField";
import { DatePickerController } from "../FormComponents/DatePickerController";

export default function QuoteForm() {
  const {
    register,
    handleSubmit,
    control,
    formState: { errors },
  } = useForm({
    mode: "onBlur",
  });

  const colSpan1 = useBreakpointValue({ base: 6, md: 2 });
  const colSpan2 = useBreakpointValue({ base: 6, md: 3 });
  const history = useHistory();

  const errorsPrefix = errors.prefix;
  const errorsVehicleBodyType = errors.vehicleBodyType;
  const errorsEngineSize = errors.engineSize;

  const controllerPrefix = {
    className: "select",
    id: "prefix",
    name: "prefix",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    isInvalid: {errorsPrefix},
    options: {prefixOptions},
    placeholder: "Select..."
  }

  const controllerFirstName = {
    id: "firstName",
    name: "firstName",
    control: {control},
    defaultValue: "",
    rules: {validationFirstName},
    type: "text",
    placeholder: "Please Enter First Name"
  }

  const controllerLastName = {
    id: "lastName",
    name: "lastName",
    control: {control},
    defaultValue: "",
    rules: {validationLastName},
    type: "text",
    placeholder: "Please Enter Last Name"
  }

  const controllerTelephoneNumber = {
    id: "telephoneNumber",
    name: "telephoneNumber",
    control: {control},
    defaultValue: "",
    rules: {validationTelephoneNumber},
    type: "tel",
    placeholder: "Please Enter Tel..."
  }

  const controllerAddressLine1 = {
    id: "addressLine1",
    name: "addressLine1",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    type: "text",
    placeholder: "Please Enter Address Line 1 (Street)..."
  }

  const controllerAddressLine2 = {
    id: "addressLine2",
    name: "addressLine2",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    type: "text",
    placeholder: "Please Enter Address Line 2 (Road)..."
  }

  const controllerCity = {
    id: "city",
    name: "city",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    type: "text",
    placeholder: "Please Enter City..."
  }

  const controllerPostcode = {
    id: "postcode",
    name: "postcode",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    type: "text",
    placeholder: "Please Enter Postcode / Zip..."
  }

  const controllerVehicleBodyType = {
    className: "select",
    id: "vehicleBodyType",
    name: "vehicleBodyType",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    isInvalid: {errorsVehicleBodyType},
    options: {vehicleBodyTypeOptions},
    placeholder: "Select..."
  }

  const controllerEngineSize = {
    className: "select",
    id: "engineSize",
    name: "engineSize",
    control: {control},
    defaultValue: "",
    rules: {validationRequiredField},
    isInvalid: {errorsEngineSize},
    options: {engineSizeOptions},
    placeholder: "Select..."
  }

  const controllerAdditionalDrivers = {
    id: "additionalDrivers",
    name: "additionalDrivers",
    control: {control},
    defaultValue: 1,
    rules: {validationAdditionalDrivers},
    minValue: 0,
    maxValue: 4,
    precision: 0,
    clampValueOnBlur: false
  }

  const controllerCurrentValue = {
    id: "currentValue",
    name: "currentValue",
    control: {control},
    defaultValue: 0,
    rules: {validationCurrentValue},
    minValue: 0,
    maxValue: 50000,
    precision: 2,
    clampValueOnBlur: false
  }

  const registerCommercialUseYes = {
    htmlFor: "commercialUse-yes",
    register: {...register("commercialUse", {
        required: "This is a required field",
      })},
    type:"radio",
    value:"Yes",
    content:"Yes",
    id:"commercialUse-yes"
  }

  const registerCommercialUseNo = {
    htmlFor: "commercialUse-no",
    register: {...register("commercialUse", {
        required: "This is a required field",
      })},
    type:"radio",
    value:"No",
    content:"No",
    id:"commercialUse-no"
  }

  const registerOutsideStateUseYes = {
    htmlFor: "outsideStateUse-yes",
    register: {...register("outsideStateUse", {
        required: "This is a required field",
      })},
    type:"radio",
    value:"Yes",
    content:"Yes",
    id:"outsideStateUse-yes"
  }

  const registerOutsideStateUseNo = {
    htmlFor: "outsideStateUse-no",
    register: {...register("outsideStateUse", {
        required: "This is a required field",
      })},
    type:"radio",
    value:"No",
    content:"No",
    id:"outsideStateUse-no"
  }

  const controllerDateRegistered = {
    className: "react-datapicker__input-text",
    id: "dateRegistered",
    name: "dateRegistered",
    control: {control},
    defaultValue: new Date(),
    rules: {validationRequiredField},
    dateFormat: "dd/MM/yyyy",
    filterDate: (date) => {
    return moment() > date;
    }
  }

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
              <GridItem colSpan={colSpan1}>
                <FormControl isRequired isInvalid={errors.prefix}>
                  <FormLabel htmlFor="prefix">Prefix</FormLabel>
                  <SelectController selectController={ controllerPrefix }/>
                  <FormErrorMessage>
                    {errors.prefix && errors.prefix.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan1}>
                <FormControl isRequired isInvalid={errors.firstName}>
                  <FormLabel htmlFor="firstName">First Name</FormLabel>
                  <InputFieldController inputFieldController={ controllerFirstName }/>
                  <FormErrorMessage>
                    {errors.firstName && errors.firstName.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan1}>
                <FormControl isRequired isInvalid={errors.lastName}>
                  <FormLabel htmlFor="lastName">Last Name</FormLabel>
                  <InputFieldController inputFieldController={ controllerLastName }/>
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
                  <InputFieldController inputFieldController={ controllerTelephoneNumber}/>
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
                  <InputFieldController inputFieldController={ controllerAddressLine1 }/>
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
                  <InputFieldController inputFieldController={ controllerAddressLine2 }/>
                  <FormErrorMessage>
                    {errors.addressLine2 && errors.addressLine2.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.city}>
                  <FormLabel htmlFor="city">City</FormLabel>
                  <InputFieldController inputFieldController={ controllerCity }/>
                  <FormErrorMessage>
                    {errors.city && errors.city.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.postcode}>
                  <FormLabel htmlFor="postcode">Postcode / Zip</FormLabel>
                  <InputFieldController inputFieldController={ controllerPostcode }/>
                  <FormErrorMessage>
                    {errors.postcode && errors.postcode.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.vehicleBodyType}>
                  <FormLabel htmlFor="vehicleBodyType">Vehicle Type</FormLabel>
                  <SelectController selectController={ controllerVehicleBodyType }/>
                  <FormErrorMessage>
                    {errors.vehicleBodyType && errors.vehicleBodyType.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.engineSize}>
                  <FormLabel htmlFor="engineSize">Engine Size</FormLabel>
                  <SelectController selectController={ controllerEngineSize }/>
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
                  <NumberInputFieldController numberInputFieldController={controllerAdditionalDrivers}/>
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
                  <div>
                    <RadioInputField radioInputField={ registerCommercialUseYes} />
                    <RadioInputField radioInputField={ registerCommercialUseNo} />
                  </div>
                  <FormErrorMessage>
                    {errors.commercialUse &&
                      errors.commercialUse.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.outsideStateUse}>
                  <FormLabel htmlFor="outsideStateUse">
                    Will the vehicle be used outside the registered state?
                  </FormLabel>
                  <div>
                    <RadioInputField radioInputField={ registerOutsideStateUseYes} />
                    <RadioInputField radioInputField={ registerOutsideStateUseNo} />
                  </div>
                  <FormErrorMessage>
                    {errors.outsideStateUse &&
                      errors.outsideStateUse.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={colSpan2}>
                <FormControl isRequired isInvalid={errors.currentValue}>
                  <FormLabel htmlFor="currentValue">
                    What is the current value of the vehicle ($0-$50,000)?
                  </FormLabel>
                  <NumberInputFieldController numberInputFieldController={ controllerCurrentValue }/>
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
                  <DatePickerController datePickerController={ controllerDateRegistered }/>
                  <FormErrorMessage>
                    {errors.dateRegistered && errors.dateRegistered.message}
                  </FormErrorMessage>
                </FormControl>
              </GridItem>
              <GridItem colSpan={6}>
                <Button type="submit" size="lg" w="50%">
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
