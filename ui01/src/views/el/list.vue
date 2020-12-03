<template>
  <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="date"
        label="日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
    </el-table>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
  name: "list",
  components: {},
  data() {return{}},
  created() {
    axios.get("/test/domain.json").then((res) => {
      console.log(res);
    });
  },
};
</script>