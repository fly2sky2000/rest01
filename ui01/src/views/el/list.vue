<template>
  <div id="tradingRecordDiv">
    <el-form ref="tradingRecordForm" :model="tradingRecord" :inline="true">
      <el-row>
        <el-form-item label="记账日期" prop="bookedDate" required>
          <el-date-picker
            v-model="tradingRecord.bookedDate"
            align="left"
            type="date"
            format="yyyy 年 MM 月 dd 日"
            placeholder="选择日期"
            :picker-options="pickerOptions"
            
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="币种" required>
          <el-select v-model="tradingRecord.coinCode" placeholder="请选择币种">
            <el-option label="BTC" value="BTC"></el-option>
            <el-option label="ETH" value="ETH"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="数量" prop="quantity" required>
          <el-input
            v-model="tradingRecord.quantity"
            placeholder="请输入数量"
            clearable
            
          ></el-input>
        </el-form-item>
        <el-form-item label="单价" prop="money" required>
          <el-input
            v-model="tradingRecord.money"
            placeholder="请输入单价"
            clearable
            
          ></el-input>
        </el-form-item>

        <el-form-item label="备注" prop="remark">
          <el-input
            type="textarea"
            v-model="tradingRecord.remark"
            :autosize="{ minRows: 2, maxRows: 4 }"
            placeholder="请输入备注"
            clearable
          ></el-input>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item label="类型">
          <el-select
            v-model="tradingRecord.tradingType"
            placeholder="请选择类型"
            disabled
          >
            <el-option label="买入" value="BUY"></el-option>
            <el-option label="卖出" value="SELL"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="单位">
          <el-select v-model="tradingRecord.unit" placeholder="单位" disabled>
            <el-option label="CNY" value="CNY"></el-option>
            <el-option label="BTC" value="BTC"></el-option>
            <el-option label="USD" value="USD"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="价格类型">
          <el-select
            v-model="tradingRecord.priceType"
            placeholder="价格类型"
            disabled
          >
            <el-option label="总价" value="TOTAL"></el-option>
            <el-option label="单价" value="UNIT"></el-option>
          </el-select>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item>
          <el-button
            class="btn-auto"
            @click="handleSave('tradingRecordForm')"
            type="success"
            >{{ isEdit ? "保存" : "新增" }}</el-button
          >
          <el-button
            class="btn-auto"
            @click="handleCancel('tradingRecordForm')"
            type="info"
            v-show="isEdit ? true : false"
            >取消</el-button
          >
        </el-form-item>
      </el-row>
    </el-form>
    <el-table
      :data="tableData"
      style="width: 100%"
      :border="true"
      :stripe="true"
      :highlight-current-row="true"
    >
      <el-table-column
        label="NO."
        min-width="40"
        :resizable="true"
        type="index"
      >
      </el-table-column>
      <el-table-column
        prop="bookedDate"
        label="交易日期"
        min-width="60"
        :show-overflow-tooltip="true"
        :resizable="true"
        :formatter="dateFormater"
      >
      </el-table-column>
      <el-table-column
        prop="coinCode"
        label="币种"
        min-width="40"
        :resizable="true"
      >
      </el-table-column>
      <el-table-column
        prop="tradingType"
        label="交易类型"
        min-width="50"
        :resizable="true"
        :formatter="tradingTypeFormater"
      >
      </el-table-column>
      <el-table-column
        prop="quantity"
        label="数量"
        min-width="50"
        :resizable="true"
        :formatter="balanceFormater"
      >
      </el-table-column>

      <el-table-column
        prop="money"
        label="单价"
        min-width="50"
        :resizable="true"
        :formatter="currencyFormater"
      >
      </el-table-column>
      <el-table-column
        prop="unit"
        label="单位"
        min-width="50"
        :resizable="true"
      >
      </el-table-column>
      <el-table-column
        prop="priceType"
        label="价格类型"
        min-width="50"
        :resizable="true"
        :formatter="priceTypeFormater"
      >
      </el-table-column>
      <el-table-column
        prop="remark"
        label="备注"
        min-width="80"
        :show-overflow-tooltip="true"
        :resizable="true"
      >
      </el-table-column>
      <el-table-column
        prop="createdBy"
        label="创建人"
        min-width="40"
        :resizable="true"
      >
      </el-table-column>
      <el-table-column
        prop="createdTime"
        label="创建时间"
        min-width="100"
        :show-overflow-tooltip="true"
        :resizable="true"
        :formatter="dateTimeFormater"
      >
      </el-table-column>
      <el-table-column
        prop="updatedBy"
        label="更新人"
        min-width="40"
        :resizable="true"
      >
      </el-table-column>
      <el-table-column
        prop="updatedTime"
        label="更新时间"
        min-width="100"
        :show-overflow-tooltip="true"
        :resizable="true"
        :formatter="dateTimeFormater"
      >
      </el-table-column>
      <el-table-column label="操作" min-width="120" :resizable="true">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
// @ is an alias to /src
import {
  listTradingRecord,
  addTradingRecord,
  delTradingRecord,
  updateTradingRecord,
} from "@/api/tradingRecord";
import moment from "moment";
import numeral from "numeral";

let newTradingRecord = {
  bookedDate: Date.now(), //交易日期
  coinCode: "BTC", //币种
  quantity: null, //交易数量
  tradingType: "BUY", //交易类型;1买入,2卖出
  money: null, //交易金额
  unit: "CNY", //交易单位
  priceType: "UNIT", //价格类型;1总价,2单价
  remark: null, //备注
  createdBy: "felix", //创建人
  updatedBy: "felix", //更新人
};
export default {
  name: "list",
  data() {
    return {
      isEdit: false,
      tableData: [],
      tradingRecord: JSON.parse(JSON.stringify(newTradingRecord)),
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            },
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            },
          },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    //获取交易记录清单
    getList() {
      listTradingRecord({ sort: "updatedTime,desc" }).then((res) => {
        this.tableData = res._embedded.tradingRecord;
      });
    },
    //添加一条交易记录
    handleSave(formName) {
      this.$refs[formName].validate((valid) => {
        if (!valid) {
          this.$message("校验错误！");
          return false;
        } else {
          if (this.tradingRecord.id == undefined) {
            //新增记录
            addTradingRecord(this.tradingRecord).then((res) => {
              console.log(res);
              this.getList();
              this.tradingRecord = JSON.parse(JSON.stringify(newTradingRecord));
              this.$refs[formName].resetFields();
              this.$message("创建成功！");
            });
          } else {
            this.tradingRecord.updatedTime = null;
            updateTradingRecord(this.tradingRecord).then((res) => {
              console.log(res);
              this.getList();
              this.tradingRecord = JSON.parse(JSON.stringify(newTradingRecord));
              this.isEdit=false;
              this.$refs[formName].resetFields();
              
              this.$message("更新成功！");
            });
          }
        }
      });
    },
    //编辑交易记录
    handleCancel(formName) {
      this.isEdit = false;
      this.tradingRecord = JSON.parse(JSON.stringify(newTradingRecord));
      this.$refs[formName].resetFields();
    },
    //取消编辑交易记录
    handleEdit(index, row) {
      this.isEdit = true;
      this.tradingRecord = JSON.parse(JSON.stringify(row));
    },
    //删除交易记录
    handleDelete(index, row) {
      this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        delTradingRecord(row.id).then((res) => {
          this.getList();
          this.$message("删除成功！");
        });
      });
    },
    //交易类型字典格式化
    tradingTypeFormater: function(row, column, cellValue, index) {
      let tradingType = row[column.property];
      if (tradingType == undefined) {
        return "";
      }
      return tradingType == "BUY" ? "买入" : "卖出";
    },
    //价格类型字典格式化
    priceTypeFormater: function(row, column, cellValue, index) {
      let priceType = row[column.property];
      if (priceType == undefined) {
        return "";
      }
      return priceType == "TOTAL" ? "总价" : "单价";
    },
    //日期格式化
    dateFormater: function(row, column, cellValue, index) {
      let date = row[column.property];
      if (date == undefined) {
        return "";
      }
      //moment.tz.setDefault("Asia/Shanghai");
      return moment(date).format("YYYY-MM-DD");
    },
    //日期时间格式化
    dateTimeFormater: function(row, column, cellValue, index) {
      let date = row[column.property];
      if (date == undefined) {
        return "";
      }
      //moment.tz.setDefault("Asia/Shanghai");
      return moment(date).format("YYYY-MM-DD HH:mm:ss");
    },
    //币数格式化
    balanceFormater: function(row, column, cellValue, index) {
      let balance = row[column.property];
      if (balance == undefined) {
        return "";
      }
      //moment.tz.setDefault("Asia/Shanghai");
      let number = numeral(balance);
      return number.format("0.0000");
    },
    //货币格式化
    currencyFormater: function(row, column, cellValue, index) {
      let currency = row[column.property];
      if (currency == undefined) {
        return "";
      }
      let number = numeral(currency);
      //moment.tz.setDefault("Asia/Shanghai");
      return number.format("0,0");
    },
  },
};
</script>
