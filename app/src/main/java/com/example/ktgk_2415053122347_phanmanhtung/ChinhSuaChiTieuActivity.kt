package com.example.ktgk_2415053122347_phanmanhtung

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_2415053122347_phanmanhtung.databinding.ActivityChinhSuaChiTieuBinding

class ChinhSuaChiTieuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChinhSuaChiTieuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title =
            "Phan Manh Tung - 2415053122347 - Quản lý chi tiêu cá nhân"
        val tenkhoanchi_347 = intent.getStringExtra("TENKHOANCHI")
        val sotien_347 = intent.getDoubleExtra("SOTIEN",-1.0)
        val ghichu_347 = intent.getStringExtra("GHICHU")?:"Chưa cập nhật"
        with(binding){
            edtTenKhoanChi347.setText("$tenkhoanchi_347")
            edtSoTien347.setText("$sotien_347")
            edtGhiChu347.setText("$ghichu_347")
        }

    }
}