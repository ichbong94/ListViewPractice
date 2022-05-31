package com.example.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listviewpractice.adapters.StudentAdapter
import com.example.listviewpractice.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val mStudentList = ArrayList<Student>()
    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("이희봉", 1965))
        mStudentList.add(Student("이희봉2", 1975))
        mStudentList.add(Student("이희봉3", 1985))
        mStudentList.add(Student("이희봉4", 1985))
        mStudentList.add(Student("이희봉5", 1925))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)
        studentListView.adapter = mAdapter

        studentListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name}", Toast.LENGTH_SHORT).show()

        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            val longClickedStudent = mStudentList[position]
            Toast.makeText(this, "${longClickedStudent.name}길게", Toast.LENGTH_SHORT).show()

            return@setOnItemLongClickListener true
        }

    }
}