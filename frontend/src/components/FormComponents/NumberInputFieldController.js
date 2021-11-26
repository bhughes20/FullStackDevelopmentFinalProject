import React from "react";
import {Controller} from "react-hook-form";
import {
    NumberDecrementStepper,
    NumberIncrementStepper,
    NumberInput,
    NumberInputField,
    NumberInputStepper
} from "@chakra-ui/react";

export const NumberInputFieldController = (
    {
        id,
        name,
        control,
        defaultValue,
        rules,
        minValue,
        maxValue,
        precision,
        clampValueOnBlur
    }) => {

    return(
        <Controller
            id={id}
            name={name}
            control={control}
            defaultValue={defaultValue}
            rules={rules}
            render={({ field: { onChange, onBlur } }) => (
                <NumberInput
                    defaultValue={defaultValue}
                    min={minValue}
                    max={maxValue}
                    precision={precision}
                    clampValueOnBlur={clampValueOnBlur}
                    onChange={onChange}
                    onBlur={onBlur}
                >
                    <NumberInputField />
                    <NumberInputStepper>
                        <NumberIncrementStepper />
                        <NumberDecrementStepper />
                    </NumberInputStepper>
                </NumberInput>
            )}
        />
    );
}