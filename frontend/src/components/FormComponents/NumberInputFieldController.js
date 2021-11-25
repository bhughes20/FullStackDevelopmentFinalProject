import React from "react";
import {Controller} from "react-hook-form";
import {
    NumberDecrementStepper,
    NumberIncrementStepper,
    NumberInput,
    NumberInputField,
    NumberInputStepper
} from "@chakra-ui/react";

export const NumberInputFieldController = (props) => {

    const numberInputFieldController = props.numberInputFieldController;

    return(
        <Controller
            id={numberInputFieldController.id}
            name={numberInputFieldController.name}
            control={numberInputFieldController.control}
            defaultValue={numberInputFieldController.defaultValue}
            rules={numberInputFieldController.rules}
            render={({ field: { onChange, onBlur } }) => (
                <NumberInput
                    defaultValue={numberInputFieldController.defaultValue}
                    min={numberInputFieldController.minValue}
                    max={numberInputFieldController.maxValue}
                    precision={numberInputFieldController.precision}
                    clampValueOnBlur={numberInputFieldController.clampValueOnBlur}
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