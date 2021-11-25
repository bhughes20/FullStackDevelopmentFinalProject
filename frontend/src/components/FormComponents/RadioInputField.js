import React from "react";

export const RadioInputField = (props, register) => {

    const radioInputField = props.radioInputField;

    return(

        <label
            className="radio-label"
            htmlFor={radioInputField.label}
        >
            <input
                register={register}
                type={radioInputField.type}
                value={radioInputField.value}
                id={radioInputField.id}
            />
            <span className="checkmark"></span>
            {radioInputField.content}
        </label>
    );
}