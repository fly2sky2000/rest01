import request from "@/utils/request"

export function listTraddingRecord(query){
    return request({
        url:"/traddingRecord",
        method:"get",
        params: query
    })
}