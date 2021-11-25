export const validationRequiredField = (fieldName) =>
    `${fieldName} is a required field`;

export const validationFirstName = {
    required: "First Name is a required field",
    maxLength: {
        value: 50,
        message: "Max length is 50 characters"
    },
    pattern: {
        value: /^[a-z ,.'-]+$/i,
        message: "Names must begin with a letter",
    }
};

export const validationLastName = {
    required: "Last Name is a required field",
    maxLength: {
        value: 50,
        message: "Max length is 50 characters"
    },
    pattern: {
        value: /^[a-z ,.'-]+$/i,
        message: "Names must begin with a letter",
    }
};

export const validationTelephoneNumber = {
    required: "Telephone Number is a required field",
    pattern: {
        value: /^[0-9]/i,
        message: "Telephone Number must be numeric digits",
    },
    maxLength: {
        value: 11,
        message: "Telephone Number must be 11 digits",
    },
    minLength: {
        value: 11,
        message: "Telephone Number must be 11 digits",
    }
};

export const validationAdditionalDrivers = {
    required: "This is a required field",
    max: {
        value: 4,
        message: "Cannot have more than 4 additional drivers",
    },
    min: {
        value: 0,
        message: "Minimum number allowed is 0",
    }
};

export const validationCurrentValue = {
    required: "This is a required field",
    max: {
        value: 50000,
        message: "Value cannot be greater than $50,000",
    },
    min: {
        value: 0,
        message: "Value cannot be less than $0",
    }
};

export const validationDriverId = {
    required: "Driver ID is a required field",
    pattern: {
        value: /^[0-9]/i,
        message: "ID must be numeric digits",
    }
};








