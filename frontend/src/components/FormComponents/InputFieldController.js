import React from "react";
import {Controller} from "react-hook-form";
import {Input} from "@chakra-ui/react";

export const InputFieldController = (
    {
        id,
        name,
        control,
        defaultValue,
        rules,
        placeholder,
        type
    }) => {

    return(
        <Controller
            id={id}
            name={name}
            control={control}
            defaultValue={defaultValue}
            rules={rules}
            render={({ field: { value, onChange, onBlur } }) => (
                <Input
                    type={type}
                    value={value}
                    onChange={onChange}
                    onBlur={onBlur}
                    placeholder={placeholder}
                />
            )}
        />
    );
}