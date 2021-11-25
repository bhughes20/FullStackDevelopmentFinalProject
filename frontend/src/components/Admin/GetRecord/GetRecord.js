import React from "react";
import { useForm, Controller } from "react-hook-form";
import { useHistory } from "react-router-dom";
import { toast } from "react-toastify";
import axios from "axios";
import {
  Heading,
  HStack,
  FormControl,
  FormLabel,
  FormErrorMessage,
  Input,
  Button,
  SimpleGrid,
  GridItem,
  useBreakpointValue,
} from "@chakra-ui/react";
import { validationDriverId } from "../../ValidationOptions";
import { InputFieldController } from "../../FormComponents/InputFieldController";

export default function GetRecord() {
  const history = useHistory();
  const colSpan = useBreakpointValue({ base: 3, md: 1 });

  const {
    handleSubmit,
    control,
    formState: { errors },
  } = useForm({
    mode: "onBlur",
  });

  const controllerDriverId = {
    id: "driverId",
    name: "driverId",
    control: {control},
    defaultValue: "",
    rules: {validationDriverId},
    type: "text",
    placeholder: "Please Enter Driver ID"
  }

  const handleRegistration = (data) => {
    const id = data.driverId;
    checkDriverRecordExists(id);
  };

  const checkDriverRecordExists = (id) => {
    const url = `/api/drivers/${id}`;
    const redirectEndpoint = `/driver-details/${id}`;
    axios
      .get(url)
      .then((response) => {
        if (response.status >= 200 && response.status < 300){
          history.push(redirectEndpoint);
        }
      })
      .catch((error) => {
        if(error.response.status === 404){
          toast.error(`Sorry, Driver ID ${id} does not exist.`)
        } else {
          toast.error("Oops, something went wrong!")
        }
      });
  };

  const handleError = (errors) => {
    console.log(errors);
  };

  return (
    <form onSubmit={handleSubmit(handleRegistration, handleError)}>
      <SimpleGrid
        padding={[5, 10]}
        bgColor="grey.300"
        columns={3}
        columnGap={3}
        rowGap={6}
        flexGrow={1}
        w="full"
      >
        <GridItem colSpan={3}> 
          <Heading as="h2" size="lg">
            Get Driver Details
          </Heading>
        </GridItem>
        <GridItem colSpan={colSpan}>
          <FormControl isRequired isInvalid={errors}>
            <FormLabel htmlFor="driverId">Driver ID</FormLabel>
            <InputFieldController inputFieldController={ controllerDriverId }/>
            <FormErrorMessage>
              {errors &&
                errors.message}
            </FormErrorMessage>
          </FormControl>
        </GridItem>
        <HStack alignItems="end">
        <GridItem colSpan={colSpan} >
          <Button type="submit" size="md">
            Get Details
          </Button>
        </GridItem>
        </HStack>
      </SimpleGrid>
    </form>
  );
}
