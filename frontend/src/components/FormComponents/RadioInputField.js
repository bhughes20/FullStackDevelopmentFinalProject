import React from "react";

export const RadioInputField = (props) => {

    const radioInputField = props.radioInputField;

    return(
        <label
            className="radio-label"
            htmlFor={radioInputField.label}
        >
            <input
                {radioInputField.rules}
                type={radioInputField.type}
                value={radioInputField.value}
                id={radioInputField.id}
            />
            <span className="checkmark"></span>
            {radioInputField.value}
        </label>
    );
}