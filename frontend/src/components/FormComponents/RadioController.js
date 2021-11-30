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

    return (
        <Controller
            id={id}
            control={control}
            name={name}
            defaultValue={defaultValue}
            rules={rules}
            render={({field: {value, onChange, onBlur}}) => (
                <RadioGroup
                    value={value}
                    onChange={(val) => onChange(val)}
                    onBlur={(val) => onBlur(val)}
                >
                    <Stack direction='row'>
                        <Radio
                            isInvalid={isInvalid}
                            value='Yes'
                            bg={"blue.200"}
                            borderColor={"indigo.400"}
                        >
                            Yes
                        </Radio>
                        <Radio
                            isInvalid={isInvalid}
                            value='No'
                            bg={"blue.200"}
                            borderColor={"indigo.400"}
                        >
                            No
                        </Radio>
                    </Stack>
                </RadioGroup>
            )}
        />
    );
}