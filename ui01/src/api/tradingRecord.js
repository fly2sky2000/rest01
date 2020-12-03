import request from "@/utils/request"

export function listTradingRecord(query){
    return request({
        url:"/tradingRecord",
        method:"get",
        params: query
    })
}