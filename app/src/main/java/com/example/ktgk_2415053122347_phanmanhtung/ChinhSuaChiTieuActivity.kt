package com.example.ktgk_2415053122347_phanmanhtung

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        binding.btnHuyChinhSua347.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
        binding.btnChinhSua347.setOnClickListener {
            val newten_347 = binding.edtTenKhoanChi347.text.trim().toString()
            val newsotien_347 = binding.edtSoTien347.text.trim().toString().toDoubleOrNull()
            val ghichu_347 = binding.edtGhiChu347.text.trim().toString()
            if (newten_347.isNullOrBlank()){
                binding.edtTenKhoanChi347.error ="Vui long nhap ten khoan chi hop le"
            }
            else
                if (newsotien_347 == null || newsotien_347 <=0.0)
                    binding.edtSoTien347.error ="Vui long nhap so tien hop le"
                else
                {
                    val resultIntent = Intent().apply {
                        putExtra("TENKHOANCHI",newten_347)
                        putExtra("SOTIEN",newsotien_347)
                        putExtra("GHICHU",ghichu_347)
                    }
                    setResult(RESULT_OK,resultIntent)
                    finish()
                }
        }

    }
}