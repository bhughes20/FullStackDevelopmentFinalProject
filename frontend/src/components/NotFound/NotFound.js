import React from "react";
import {Container, Flex, Heading, Text, VStack} from "@chakra-ui/react";

export default function NotFound() {
  return (
      <Container maxWidth="container.xl" padding={0}>
        <Flex
            bgColor="grey.400"
            h={{ base: "auto", md: "full" }}
            py={[5, 10]}
            direction={{ base: "column-reverse", md: "row" }}
        >
          <VStack w="full" h="full" px={5} spacing={10} alignItems="center">
            <VStack spacing={3} alignItems="center">
              <Heading size="xl">Oops, something went wrong</Heading>
              <Text>You have landed on a page that doesn't exist.</Text>
            </VStack>
          </VStack>
        </Flex>
      </Container>
  );
}

