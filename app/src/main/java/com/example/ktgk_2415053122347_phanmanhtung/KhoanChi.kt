package com.example.ktgk_2415053122347_phanmanhtung

data class KhoanChi(val maKhoanChi_347:Int, val tenKhoanChi_347:String, val soTien_347:Double, val ghiChu_347:String, val daThanhToan_347:Boolean){
    fun laythongtin():String{
        return "Khoan chi "+ "Ma khoan chi: $maKhoanChi_347" + "-Ten khoan chi: $tenKhoanChi_347" +"-So tien: $soTien_347"
    }
    fun laSoTienHopLe(): Boolean{
        if (soTien_347.isFinite() && soTien_347>0.0)
            return true
        else
            return false
    }
}
