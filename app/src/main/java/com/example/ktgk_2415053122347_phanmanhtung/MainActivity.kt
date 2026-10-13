package com.example.ktgk_2415053122347_phanmanhtung

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_2415053122347_phanmanhtung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tenkhoanchi_347 = ""
    private var sotien_347= 0.0
    private var ghichu_347 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title="Phan Manh Tung_2347"
        binding.btnThem347.setOnClickListener {
            tenkhoanchi_347 = binding.edtTenKhoanChi347.text.trim().toString()
            sotien_347 = binding.edtSoTien347.text.toString().trim().toDoubleOrNull()?:-1.0
            ghichu_347 = binding.edtGhiChu347.text.toString()
            if (tenkhoanchi_347.isBlank())
            {
                binding.edtTenKhoanChi347.error ="Ten khoan chi khong hop le"
            }
            else
                if (sotien_347 == null || sotien_347 <0.0)
                    binding.edtSoTien347.error = "So tien khong hop le"
                else
                {
                    Toast.makeText(this, "Them khoan chi thanh cong", Toast.LENGTH_SHORT).show()
                }
        }
        binding.btnXemChiTiet347.setOnClickListener {
            val message = "Thông tin khoảng chi đã thêm: $tenkhoanchi_347- $sotien_347 - $ghichu_347"
            Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
        }
    }
}