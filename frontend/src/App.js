import theme from "./theme/Theme";
import "./theme/styles.css";
import "react-datepicker/src/stylesheets/datepicker.scss";
import "react-toastify/dist/ReactToastify.css";
import {ToastContainer} from "react-toastify";
import {ChakraProvider} from "@chakra-ui/react";
import {HashRouter, Route, Switch} from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";
import QuoteForm from "./components/QuoteForm/QuoteForm";
import Admin from "./components/Admin/Admin";
import DriverDetails from "./components/DriverDetails/DriverDetails";
import NotFound from "./components/NotFound/NotFound";

function App() {
    return (
        <ChakraProvider theme={theme}>
            <ToastContainer
                position="top-center"
                autoClose={2000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
            />
            <HashRouter>
                <Navbar/>
                <Switch>
                    <Route exact path="/">
                        <QuoteForm/>
                    </Route>
                    <Route exact path="/admin">
                        <Admin/>
                    </Route>
                    <Route path="/driver-details/:id">
                        <DriverDetails/>
                    </Route>
                    <Route>
                        <NotFound/>
                    </Route>
                </Switch>
            </HashRouter>
        </ChakraProvider>
    );
}

export default App;
