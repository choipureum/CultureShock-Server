package com.cultureshock.madeleine.rest.dto.response.performance

import com.cultureshock.madeleine.domain.performance.LocationDetail
import com.cultureshock.madeleine.domain.performance.Performance
import com.cultureshock.madeleine.domain.performance.PerformanceDetail
import java.time.LocalDate
import java.util.*

data class PerformanceResponse (
    val id: Long,
    val performId: String,
    val performName: String,
    val performStartDate: Date,
    val performEndDate: Date,
    val hallName: String,
    val posterUrl: String,
    var performState: String,
    val performKind: String,
) {
    companion object {
        fun of(performance: Performance): PerformanceResponse {
            return PerformanceResponse(
                id = performance.id,
                performId = performance.performId,
                performName = performance.performName,
                performStartDate = performance.performStartDate,
                performEndDate = performance.performEndDate,
                hallName = performance.hallName,
                posterUrl = performance.posterUrl,
                performState = performance.performState,
                performKind = performance.performKind
            )
        }
    }
}
data class PerformanceDetailListResponse (
    val totalCount: Long,
    val totalPages: Int,
    val performanceList: MutableList<PerformanceDetail>
){
    companion object{
        fun of(performanceDetailList: MutableList<PerformanceDetail>, totalCount: Long, totalPages: Int ): PerformanceDetailListResponse{
            return PerformanceDetailListResponse(
                totalCount = totalCount,
                totalPages = totalPages,
                performanceList = performanceDetailList
            )
        }
    }
}


data class PerformanceListResponse (
    val totalCount: Long,
    val totalPages: Int,
    val performanceList: MutableList<PerformanceEntityResponse>
){
    companion object{
        fun of(performanceList: MutableList<PerformanceEntityResponse>, totalCount: Long, totalPages: Int ): PerformanceListResponse{
            return PerformanceListResponse(
                totalCount = totalCount,
                totalPages = totalPages,
                performanceList = performanceList
            )
        }
    }
}

data class PerformanceDetailResponse (
    val id: Long, //seq
    val performId: String,      //공연ID
    val hallId: String,      //공연시설ID
    val performName: String,       //공연명
    val performStartDate: Date,     //공연시작일
    val performEndDate: Date,       //공연종료일
    val hallName: String?,    //공연시설명(공연장명)
    val performCast: String?,    //공연출연진
    val performCrew: String?,    //공연제작진
    val performRuntime: String?, //공연런타임
    var performAge: String,//공연 관람 연령
    var enterName: String?,   //제작사
    var price: String,//티켓가격
    val posterUrl: String,      //포스터 이미지 경로
    val performKind: String?,     //장르
    var performState: String?,    //공연상태
    val performPhotoUrl : List<String?>,
    var performTime: String?,   //공연시간
    var locationDetailResponse: LocationDetailResponse?             //경도
) {
    companion object {
        fun of(performanceDetail: PerformanceDetail, locationDetail: LocationDetail?): PerformanceDetailResponse {
            return PerformanceDetailResponse(
                id = performanceDetail.pid,
                performId = performanceDetail.performId,
                performKind = performanceDetail.performKind,
                hallId = performanceDetail.hallId,
                performName = performanceDetail.performName,
                performStartDate = performanceDetail.performStartDate,
                performEndDate = performanceDetail.performEndDate,
                hallName = performanceDetail.hallName,
                performCast = performanceDetail.performCast,
                performCrew = performanceDetail.performCrew,
                performRuntime = performanceDetail.performRuntime,
                performAge = performanceDetail.performAge,
                enterName = performanceDetail.enterName,
                price = performanceDetail.price,
                posterUrl = performanceDetail.posterUrl,
                performState = performanceDetail.performState,
                performPhotoUrl = listOf(performanceDetail.performPhotoUrl1,performanceDetail.performPhotoUrl2,performanceDetail.performPhotoUrl3,performanceDetail.performPhotoUrl4),
                performTime = performanceDetail.performTime,
                locationDetailResponse = locationDetail?.let { LocationDetailResponse.of(it) }
            )
        }
    }
}

data class PerformanceEntityResponse(
    val performId: String,
    val performName: String,
    val performStartDate: Date,
    val performEndDate: Date,
    val hallName: String?,
    val posterUrl: String,
    var performState: String?,
    val performKind: String?
)

data class LocationDetailResponse (
    val hallId: String,       //공연시설ID
    val hallName: String,      //공연 시설 명
    var hallUrl: String?,   //홈페이지
    var hallAddres: String?,       //주소
    var la: Double?,          //위도
    var lo: Double?           //경도
) {
    companion object {
        fun of(locationDetail: LocationDetail): LocationDetailResponse {
            return LocationDetailResponse(
                hallId = locationDetail.hallId,
                hallName = locationDetail.hallName,
                hallUrl = locationDetail.hallUrl,
                hallAddres = locationDetail.hallAddres,
                la = locationDetail.la,
                lo = locationDetail.lo
            )
        }
    }
}