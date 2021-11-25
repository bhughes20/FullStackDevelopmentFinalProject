import React from "react";
import {Controller} from "react-hook-form";
import {Input} from "@chakra-ui/react";

export const InputFieldController = (props) => {

    const inputFieldController = props.inputFieldController;

    return(
        <Controller
            id={inputFieldController.id}
            name={inputFieldController.name}
            control={inputFieldController.control}
            defaultValue={inputFieldController.defaultValue}
            rules={inputFieldController.rules}
            render={({ field: { value, onChange, onBlur } }) => (
                <Input
                    type={inputFieldController.type}
                    value={value}
                    onChange={onChange}
                    onBlur={onBlur}
                    placeholder={inputFieldController.placeholder}
                />
            )}
        />
    );
}