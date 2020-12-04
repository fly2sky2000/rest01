<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="coinCode" label="币种" width="180"> </el-table-column>
    <el-table-column prop="quantity" label="数量" width="180"> </el-table-column>
    <el-table-column prop="money" label="金额" width="180"> </el-table-column>
    <el-table-column prop="updatedTime" label="更新时间" width="180"> </el-table-column>
  </el-table>
</template>

<script>
// @ is an alias to /src
import { listTradingRecord } from "@/api/tradingRecord";

export default {
  name: "list",
  data() {
    return {
      tableData: [],
      instance: null
    };
  },
  created() {
    this.getList()
  },
  methods: {
    getList(){
      listTradingRecord({sort:"updatedTime,desc"}).then(res=>{
        console.log(res);
        this.tableData = res._embedded.tradingRecord;
      })
    }
  },
};
</script>