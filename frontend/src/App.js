import theme from "./theme/Theme";
import "./theme/styles.css";
import "react-datepicker/dist/react-datepicker.css";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer} from "react-toastify";
import { ChakraProvider } from "@chakra-ui/react";
import { HashRouter, Route, Switch } from "react-router-dom";
import Navbar from "./components/Navbar/Navbar";
import QuoteForm from "./components/QuoteForm/QuoteForm";
import Admin from "./components/Admin/Admin";
import DriverDetails from "./components/DriverDetails/DriverDetails";

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
                    <Route exact path="/" component={QuoteForm}/>
                    <Route exact path="/admin" component={Admin}/>
                    <Route exact path="/driver-details/:id" component={DriverDetails}/>
                    <Route component={NotFound}/>
                </Switch>
            </HashRouter>
        </ChakraProvider>
    );
}

export default App;

function NotFound() {
    return <>You have landed on a page that doesn't exist</>;
}
