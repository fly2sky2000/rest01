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
    axios.get("/test/domain.json").then((res) => {
      console.log(res);
    });
  },
};
</script>