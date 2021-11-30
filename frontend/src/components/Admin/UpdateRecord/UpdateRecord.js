import React from "react";
import {useForm} from "react-hook-form";
import {useHistory} from "react-router-dom";
import {toast} from "react-toastify";
import axios from "axios";
import {
    Heading,
    HStack,
    FormControl,
    FormLabel,
    FormErrorMessage,
    Button,
    SimpleGrid,
    GridItem,
    useBreakpointValue,
} from "@chakra-ui/react";
import {validationDriverId, validationTelephoneNumber} from "../../ValidationOptions";
import {InputFieldController} from "../../FormComponents/InputFieldController";

export default function UpdateRecord() {

    const colSpan = useBreakpointValue({base: 3, md: 1});
    const history = useHistory();

    const {
        handleSubmit,
        control,
        formState: {errors},
    } = useForm({
        mode: "onBlur",
    });

    const populateUpdateData = (data, newTelephoneNumber) => {
        return {
            prefix: data.prefix,
            firstName: data.firstName,
            lastName: data.lastName,
            telephoneNumber: newTelephoneNumber,
            addressLine1: data.addressLine1,
            addressLine2: data.addressLine2,
            city: data.city,
            postcode: data.postcode,
            vehicleBodyType: data.vehicleBodyType,
            engineSize: data.engineSize,
            additionalDrivers: data.additionalDrivers,
            commercialUse: data.commercialUse,
            outsideStateUse: data.outsideStateUse,
            currentValue: data.currentValue,
            dateRegistered: data.dateRegistered,
            id: data.id,
        };
    };

    function updateDriverData(url, updateData) {
        const id = updateData.id
        const redirectEndpoint = `/driver-details/${id}`;
        axios
            .put(url, updateData)
            .then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    toast.success(`Telephone Number for Driver ID ${id} has been updated to ${updateData.telephoneNumber}`, {
                        onClose: () => history.push(redirectEndpoint),
                    })
                }
            })
            .catch(() => {
                toast.error("Oops, something went wrong!")
            });
    }

    function getDriverData(id, url, populateUpdateData, newTelephoneNumber) {
        axios
            .get(url)
            .then(function (response) {
                const updateData = populateUpdateData(response.data, newTelephoneNumber);
                updateDriverData(url, updateData);
            })
            .catch((error) => {
                if (error.response.status === 404) {
                    toast.error(`Sorry, Driver ID ${id} does not exist.`)
                } else {
                    toast.error("Oops, something went wrong!")
                }
            });
    }

    const handleRegistration = (data) => {
        const id = data.driverId;
        const newTelephoneNumber = data.telephoneNumber;
        const url = `/api/drivers/${id}`;

        getDriverData(id, url, populateUpdateData, newTelephoneNumber);
    };

    const handleError = (errors) => {
        console.log(errors);
    };

    return (
        <form onSubmit={handleSubmit(handleRegistration, handleError)}>
            <SimpleGrid
                padding={[5, 10]}
                bgColor="blue.100"
                color={"indigo.600"}
                columns={3}
                columnGap={3}
                rowGap={6}
                w="full"
                verticalAlign="bottom"
            >
                <GridItem colSpan={3}>
                    <Heading as="h2" size="lg">
                        Update Driver Telephone Number
                    </Heading>
                </GridItem>
                <GridItem colSpan={colSpan}>
                    <FormControl
                        isRequired
                        isInvalid={errors.driverId}
                    >
                        <FormLabel htmlFor="driverId">Driver ID</FormLabel>
                        <InputFieldController
                            id={"driverId"}
                            name={"driverId"}
                            control={control}
                            defaultValue={""}
                            rules={validationDriverId}
                            type={"text"}
                            placeholder={"Please Enter Driver ID"}
                        />
                        <FormErrorMessage>
                            {errors.driverId &&
                            errors.driverId.message}
                        </FormErrorMessage>
                    </FormControl>
                </GridItem>
                <GridItem colSpan={colSpan}>
                    <FormControl
                        isRequired
                        isInvalid={errors.telephoneNumber}
                    >
                        <FormLabel htmlFor="telephoneNumber">
                            New Telephone Number
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
                            {errors.telephoneNumber &&
                            errors.telephoneNumber.message}
                        </FormErrorMessage>
                    </FormControl>
                </GridItem>
                <HStack alignItems="end">
                    <GridItem colSpan={colSpan}>
                        <Button type="submit" size="md">
                            Update
                        </Button>
                    </GridItem>
                </HStack>
            </SimpleGrid>
        </form>
    )
}
