import axios from "axios";
import service from "./index";

let instance = axios.create({
  baseURL: "http://localhost:8189/rest01",
  timeout: 1000,
});
const Http = {};
for (const key in service) {
  let api = service[key];
  axios
    .get()
    .then((res) => {
      axios.get().then((res) => {});
    })
    .catch((err) => {});
  Http[key] = async function() {
    let res = null;
    try {
      res = await axios.get("url");
    } catch (err) {
      res = err;
    }
  };
}
