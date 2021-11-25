import React, { useState, useRef } from "react";
import { useForm, Controller } from "react-hook-form";
import { toast } from "react-toastify";
import axios from "axios";
import {
  AlertDialog,
  AlertDialogBody,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogContent,
  AlertDialogOverlay,
  Heading,
  HStack,
  FormControl,
  FormLabel,
  FormErrorMessage,
  Input,
  Button,
  SimpleGrid,
  GridItem,
  useBreakpointValue
} from "@chakra-ui/react";
import { validationDriverId } from "../../ValidationOptions";
import { InputFieldController } from "../../FormComponents/InputFieldController";

export default function DeleteRecord() {
  const [isOpen, setIsOpen] = useState(false);
  const [id, setId] = useState(null);
  const onClose = () => setIsOpen(false);
  const cancelRef = useRef();
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

  const deleteRecord = () => {
    setIsOpen(false);
    const url = `/api/drivers/${id}`;
    axios
      .delete(url)
      .then((response) => {
        if (response.status >= 200 && response.status < 300){
          toast.success(`Driver ID ${id} has been deleted.`)
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

  const handleRegistration = (data) => {
    setId(data.driverId);
    setIsOpen(true);
  };

  const handleError = (errors) => {
    console.log(errors);
  };

  return (
    <>
      <AlertDialog
        isOpen={isOpen}
        leastDestructiveRef={cancelRef}
        onClose={onClose}
      >
        <AlertDialogOverlay>
          <AlertDialogContent>
            <AlertDialogHeader fontSize="lg" fontWeight="bold">
              Delete Driver Record
            </AlertDialogHeader>

            <AlertDialogBody>
              Are you sure you want to delete Driver {id} ? You can't undo this
              action afterwards.
            </AlertDialogBody>

            <AlertDialogFooter>
              <Button ref={cancelRef} onClick={onClose}>
                Cancel
              </Button>
              <Button
                colorScheme="red"
                onClick={() => {
                  deleteRecord(id);
                }}
                ml={3}
              >
                Delete
              </Button>
            </AlertDialogFooter>
          </AlertDialogContent>
        </AlertDialogOverlay>
      </AlertDialog>

      <form onSubmit={handleSubmit(handleRegistration, handleError)}>
        <SimpleGrid
          padding={[5, 10]}
          bgColor="grey.300"
          columns={3}
          columnGap={3}
          rowGap={6}
          w="full"
          verticalAlign="bottom"
        >
          <GridItem colSpan={3}>
            <Heading as="h2" size="lg">
              Delete Driver Record
            </Heading>
          </GridItem>
          <GridItem colSpan={colSpan}>
            <FormControl
              isRequired
              isInvalid={errors}
            >
              <FormLabel htmlFor="driverId">Driver ID</FormLabel>
              <InputFieldController inputFieldController={ controllerDriverId }/>
              <FormErrorMessage>
                {errors &&
                  errors.message}
              </FormErrorMessage>
            </FormControl>
          </GridItem>
          <HStack alignItems="end">
          <GridItem colSpan={colSpan}>
            <Button type="submit" size="md">
              Delete
            </Button>
          </GridItem>
          </HStack>
        </SimpleGrid>
      </form>
    </>
  );
}
