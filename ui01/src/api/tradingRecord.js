import request from "@/utils/request"

const url = "/tradingRecord";

export function listTradingRecord(params){
    return request({
        url:url+"/search/findAllOrdered",
        method:"get",
        params: params
    })
}

export function getTradingRecord(id){
    return request({
        url:url+"/"+id,
        method:"get"
    })
}

export function addTradingRecord(data){
    return request({
        url:url,
        method:"post",
        data: data
    })
}
export function updateTradingRecord(data){
    return request({
        url:url,
        method:"patch",
        data: data
    })
}

export function delTradingRecord(id){
    return request({
        url:url+"/"+id,
        method:"delete"
    })
}

