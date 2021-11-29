import React from "react";
import {
    Container,
    Flex,
    VStack,
    Heading, SimpleGrid, Text,
} from "@chakra-ui/react";
import DeleteRecord from "./DeleteRecord/DeleteRecord";
import GetRecord from "./GetRecord/GetRecord";
import UpdateRecord from "./UpdateRecord/UpdateRecord";


export default function Admin() {

    return (
        <Container
            maxWidth="container.xl"
            padding={0}
            centerContent
            bgColor="blue.200"
        >
            <Flex
                bgColor="indigo.400"
                color={"white"}
                h={{base: "auto", md: "full"}}
                py={[5, 10]}
                direction={{base: "column-reverse", md: "row"}}
            >
                <VStack w="full" h="full" px={10} spacing={10} alignItems="center">
                    <VStack spacing={3} alignItems="center">
                        <Heading size="2xl">Admin Site</Heading>
                        <Text>Display, update or delete driver records.</Text>
                    </VStack>
                    <GetRecord/>
                    <DeleteRecord/>
                    <UpdateRecord/>
                </VStack>
            </Flex>
        </Container>
    );
}
