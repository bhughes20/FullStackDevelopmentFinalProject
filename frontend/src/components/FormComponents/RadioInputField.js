import React from "react";

export const RadioInputField  = React.forwardRef((
    {
        className,
        htmlFor,
        register,
        type,
        value,
        id,
        content
    }) => {

    return(
        <label
            className={className}
            htmlFor={htmlFor}
        >
            <input
                register={register}
                type={type}
                value={value}
                id={id}
            />
            <span className="checkmark"></span>
            {content}
        </label>
    );
})