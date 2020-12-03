<template>
  <div class="div1"></div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
  name: "test",
  components: {},
  created() {
    let url = "/rest01/tradingRecord/";

    // axios.get("/test/domain.json", { params: { id: 12 } }).then((res) => {
    //   console.log(res.config.url);
    //   console.log(res);
    // });
    //创建数据
    let dataAdd1 = {
      coinCode: "BTC",
      quantity: 2.0,
      tradingType: "1",
      money: 45000.0,
      unit: "CNY",
      priceType: "2",
      bookedDate: "2020-11-24",
      remark: "",
      revision: 1,
      createdBy: "felix",
      updatedBy: "felix",
    };
    axios.post(url, dataAdd1).then((res) => {
      console.log(res.config.url);
      console.log(res);
    });
    // //获取数据
    // let id1 = "4028835575f540c40175f540d4d00000";
    // let dataEdit1 = {};
    // axios
    //   .get(url + id1, {
    //     params: {},
    //   })
    //   .then((res) => {
    //     console.log(res.config.url);
    //     console.log(res);
    //     dataEdit1 = res.data;
    //   });
    // //局部修改数据
    // dataEdit1.quantity = 3;
    // console.log(dataEdit1);
    // axios.patch(url+id1, dataEdit1).then((res) => {
    //   console.log(res.config.url);
    //   console.log(res);
    // });
    //删除数据
    // axios.delete(url+id1).then((res) => {
    //   console.log(res.config.url);
    //   console.log(res);
    // });
    //全字段更新数据
    // axios.put("/rest01/trading-record/"+id1, dataEdit1).then((res) => {
    //   console.log(res.config.url);
    //   console.log(res);
    // });
    // let formData1 = new FormData();
    // for (let key in data1) {
    //   formData1.append(key, data1[key]);
    // }
    // console.log(formData1);
    // axios.post("/rest01/trading-record", formData1).then((res) => {
    //   console.log(res.config.url);
    //   console.log(res);
    // });
    //多个请求
    // axios
    //   .all([axios.get("/test/domain.json"), axios.get("/test/domain.json")])
    //   .then(
    //     axios.spread((res1, res2) => {
    //       console.log(res1, res2);
    //     })
    //   );
    // axios.interceptors.request.use(
    //   (config) => {
    //     return config;
    //   },
    //   (err) => {
    //     return Promise.reject(err);
    //   }
    // );
    // axios.interceptors.response.use(
    //   (res) => {
    //     return res;
    //   },
    //   (err) => {
    //     return Promise.reject(err);
    //   }
    // );
  },
};
</script>
