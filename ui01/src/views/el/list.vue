<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="coinCode" label="币种" width="180"> </el-table-column>
    <el-table-column prop="quantity" label="数量" width="180"> </el-table-column>
    <el-table-column prop="money" label="金额"> </el-table-column>
  </el-table>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
  name: "list",
  data() {
    return {
      tableData: [],
      instance: null
    };
  },
  created() {
    this.instance = axios.create({baseURL:"http://localhost:8189/rest01",timeout:1000})
    this.instance.get("/tradingRecord").then(res=>{
        this.tableData = res.data._embedded.tradingRecord;
    })
  },
};
</script>