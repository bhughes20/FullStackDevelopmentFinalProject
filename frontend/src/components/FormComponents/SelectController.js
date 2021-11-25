import React from "react";
import {Controller} from "react-hook-form";
import {Select} from "chakra-react-select";

export const SelectController = (props) => {

    const selectController = props.selectController;

    return(
        <Controller
            className={selectController.className}
            id={selectController.id}
            name={selectController.name}
            control={selectController.control}
            defaultValue={selectController.defaultValue}
            rules={selectController.rules}
            render={({ field: {
                             name,
                             value,
                             onBlur,
                             onChange,
                             ref },
                     }) => (
                <Select
                    isInvalid={selectController.isInvalid}
                    name={name}
                    placeholder={selectController.placeholder}
                    options={selectController.options}
                    value={selectController.options.find((c) => c.value === value)}
                    onChange={(val) => onChange(val.value)}
                    onBlur={(val) => onBlur(val)}
                    inputRef={ref}
                />
            )}
        />
    );
}