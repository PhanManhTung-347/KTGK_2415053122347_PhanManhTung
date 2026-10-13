package com.example.ktgk_2415053122347_phanmanhtung

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_2415053122347_phanmanhtung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var khoanChiMoi: KhoanChi? = null
    private val chiTietChiTieu = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val tenmoi = result.data?.getStringExtra("TENKHOANCHI")?:""
            val sotien = result.data?.getDoubleExtra("SOTIEN",-1.0)?:-1.0
            val ghiChu =result.data?.getStringExtra("GHICHU")?:""
            khoanChiMoi = khoanChiMoi?.copy(tenKhoanChi_347 = tenmoi, soTien_347 = sotien, ghiChu_347 = ghiChu)
            with(binding){
                edtTenKhoanChi347.setText("$tenmoi")
                edtSoTien347.setText("$sotien")
                edtGhiChu347.setText("$ghiChu")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title="Phan Manh Tung_2347"

        binding.btnThem347.setOnClickListener {
            val tenKhoanChi_347 = binding.edtTenKhoanChi347.text.trim().toString()
            val soTien_347 = binding.edtSoTien347.text.toString().trim().toDoubleOrNull()?:-1.0
            val ghiChu_347 = binding.edtGhiChu347.text.toString()
            if (tenKhoanChi_347.isBlank())
            {
                binding.edtTenKhoanChi347.error ="Ten khoan chi khong hop le"
            }
            else
                if (!soTien_347.isFinite() || soTien_347 <= 0.0)
                    binding.edtSoTien347.error = "So tien khong hop le"
                else
                {
                    khoanChiMoi = KhoanChi(1,"$tenKhoanChi_347", soTien_347, "$ghiChu_347",false)
                    Toast.makeText(this, "Them khoan chi thanh cong", Toast.LENGTH_SHORT).show()
                }
        }
        binding.btnXemChiTiet347.setOnClickListener {
            khoanChiMoi?.let { kc->
                if (kc.tenKhoanChi_347.isBlank() || !kc.laSoTienHopLe())
                {
                    Toast.makeText(this, "Vui long them khoan chi truoc khi xem chi tiet", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                        putExtra("TENKHOANCHI",kc.tenKhoanChi_347)
                        putExtra("SOTIEN",kc.soTien_347)
                        putExtra("GHICHU",kc.ghiChu_347)
                    }
                    chiTietChiTieu.launch(intent)
                }
            }

        }
    }
}