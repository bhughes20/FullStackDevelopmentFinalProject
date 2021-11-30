import React from "react";
import {Controller} from "react-hook-form";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export const DatePickerController = (
    {
        className,
        id,
        name,
        control,
        defaultValue,
        rules,
        dateFormat,
        filterDate
    }) => {

    return (
        <Controller
            className={className}
            id={id}
            name={name}
            control={control}
            rules={rules}
            defaultValue={defaultValue}
            render={({field: {onChange, onBlur, value}}) => (
                <DatePicker
                    dateFormat={dateFormat}
                    selected={value}
                    filterDate={filterDate}
                    onChange={onChange}
                    onBlur={onBlur}
                />
            )}
        />
    );
}