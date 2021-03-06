import {extendTheme, theme as base, withDefaultColorScheme, withDefaultVariant} from "@chakra-ui/react"

const theme = extendTheme({

        colors: {
            grey: {
                100: "#f9fbfc",
                200: "#f3f6f9",
                300: "#e3e9ed",
                400: "#ced7e0",
                500: "#b9c6d3",
                600: "#94a1b0",
                700: "#6b7789",
                800: "#4e5969",
                900: "#2f3847"
            },
            red: {
                100: "#fae7ea",
                500: "#cf102d"
            },
            green: {
                100: "#ccf3ec",
                300: "#18e09a",
                500: "#00c39c",
                700: "#0e7e68"
            },
            lightblue: {
                100: "#d9eeff",
                500: "#45bce5"
            },
            blue: {
                100: "#d9e1f1",
                200: "#bfcce7",
                500: "#0033a0"
            },
            indigo: {
                300: "#757b95",
                400: "#273054",
                600: "#0d173b"
            }

        },
        fonts: {
            heading: `Montserrat, ${base.fonts?.heading}`,
            body: `Inter, ${base.fonts?.body}`
        },
        components: {
            Input: {
                variants: {
                    outline: {
                        field: {
                            bg: "#fff"
                        }
                    }
                }
            },
            NumberInput: {
                variants: {
                    outline: {
                        field: {
                            bg: "#fff"
                        }
                    }
                }
            },
            Radio: {
                variants: {
                        control: {
                            bg: "#fff",
                            borderRadius: 1,
                            borderWidth: 5,
                            borderColor: "indigo.400"
                        }
                }
            }
        }
    },
    withDefaultColorScheme({
        colorScheme: "lightblue",
        components: ["Button"]
    }),
    withDefaultVariant({
        variant: "outline",
        components: ["Input", "NumberInput"]
    })
);

export default theme;