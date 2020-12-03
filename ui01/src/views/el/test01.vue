<template>
  <div class="test01">
      测试按需引入
      <el-button type="primary">主要按钮</el-button>
  </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
  name: "test01",
  components: {},
  created() {
    axios.get("/rest01/tradingRecord").then((res) => {
      console.log(res);
      console.log(res.data._embedded.tradingRecord);
    });
  },
};
</script>