import React from "react";
import {Controller} from "react-hook-form";
import {
    Radio,
    RadioGroup,
    Stack,
} from "@chakra-ui/react";

export const RadioController = (
    {
        id,
        name,
        control,
        defaultValue,
        rules,
        isInvalid
    }) => {

    return(
        <Controller
            id={id}
            control={control}
            name={name}
            defaultValue={defaultValue}
            rules={rules}
            render={({ field: { value, onChange, onBlur } }) => (
                <RadioGroup
                    value={value}
                    onChange={(val) => onChange(val)}
                    onBlur={(val) => onBlur(val)}
                >
                    <Stack direction='row'>
                        <Radio isInvalid={isInvalid} value='Yes'>Yes</Radio>
                        <Radio isInvalid={isInvalid} value='No'>No</Radio>
                    </Stack>
                </RadioGroup>
            )}
        />
    );
}