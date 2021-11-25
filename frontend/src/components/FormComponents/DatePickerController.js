import React from "react";
import {Controller} from "react-hook-form";
import DatePicker from "react-datepicker";

export const DatePickerController = (props) => {

    const datePickerController = props.datePickerController;

    return(
        <Controller
            className={datePickerController.className}
            id={datePickerController.id}
            name={datePickerController.name}
            control={datePickerController.control}
            rules={datePickerController.rules}
            defaultValue={datePickerController.defaultValue}
            render={({ field: { onChange, onBlur, value } }) => (
                <DatePicker
                    dateFormat={datePickerController.dateFormat}
                    selected={value}
                    filterDate = {datePickerController.filterDate}
                    onChange={onChange}
                    onBlur={onBlur}
                />
            )}
        />
    );
}