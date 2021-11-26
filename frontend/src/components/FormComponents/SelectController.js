import React from "react";
import {Controller} from "react-hook-form";
import {Select} from "chakra-react-select";

export const SelectController  = (
    {
        className,
        id,
        name,
        control,
        defaultValue,
        rules,
        placeholder,
        isInvalid,
        options
    }) => {

    return(
        <Controller
            className={className}
            id={id}
            name={name}
            control={control}
            defaultValue={defaultValue}
            rules={rules}
            render={({ field: {
                             name,
                             value,
                             onBlur,
                             onChange,
                             ref },
                     }) => (
                <Select
                    isInvalid={isInvalid}
                    name={name}
                    placeholder={placeholder}
                    options={options}
                    value={options.find((c) => c.value === value)}
                    onChange={(val) => onChange(val.value)}
                    onBlur={(val) => onBlur(val)}
                    inputRef={ref}
                />
            )}
        />
    );
}