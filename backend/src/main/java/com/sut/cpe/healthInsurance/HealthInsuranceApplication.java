package com.sut.cpe.healthInsurance;

import com.sut.cpe.healthInsurance.entity.*;
import com.sut.cpe.healthInsurance.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootApplication
public class HealthInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthInsuranceApplication.class, args);
		Date date = new Date();  
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
    	String strDate = formatter.format(date);  
		System.out.println("Date Format with MM/dd/yyyy : "+strDate);
		System.out.println(date); 
	}

	@Bean
	ApplicationRunner init(EmployeeRepository employeeRepository, ProvinceRepository provinceRepository,SexRepository sexRepository,
	HospitalRepository hospitalRepository,ClinichospitalRepository clinichospitalRepository,HospitaltypeRepository hospitaltypeRepository,
	InsurancepackageRepository insurancepackageRepository, CustomerRepository customerRepository, InsurancetypeRepository insurancetypeRepository, PaidtypeRepository paidtypeRepository,
	BranchRepository branchRepository,
	ContactRepository contactRepository, HeadingRepository headingRepository,
	CurebyRepository curebyRepository, PaychecksRepository paychecksRepository,TreatmethodRepository treatmethodRepository) {
		return args -> {

			Stream.of("Korat Hospital","BOBO Hospital").forEach(name -> {
				Hospital hospital = new Hospital(); // สร้าง Object Employee
				hospital.setHname(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				hospitalRepository.save(hospital); // บันทึก Objcet ชื่อ Employee
			});

			Stream.of("Takoonkan  Bunjan", "Natalee Satong", "Sawadee Yambai").forEach(name -> {
				Employee employee = new Employee(); // สร้าง Object Employee
				employee.setEmpName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				employeeRepository.save(employee); // บันทึก Objcet ชื่อ Employee
			});

			Stream.of("ชาย", "หญิง").forEach(name -> {
				Sex sex = new Sex(); // สร้าง Object Sex
				sex.setSex(name); // set ชื่อ (name) ให้ Object ชื่อ Sex
				sexRepository.save(sex); // บันทึก Objcet ชื่อ Sex
			});

			Stream.of("นครราชสีมา", "บุรีรัมย์", "ร้อยเอ็ด", "ขอนแก่น").forEach(name -> {
				Province province = new Province(); // สร้าง Object Province
				province.setProvince(name); // set ชื่อ (name) ให้ Object ชื่อ Province
				provinceRepository.save(province); // บันทึก Objcet ชื่อ Province
			});

			Stream.of("Cherprang").forEach(name -> {
				Customer customer = new Customer(); // สร้าง Object Customer
				customer.setCusName("aloha baboon"); // set ชื่อ (name) ให้ Object ชื่อ cusName
				customer.setIdentification("12345215489874"); // set ชื่อ (name) ให้ Object ชื่อ idetification
				customer.setBirth(null);// set ชื่อ (name) ให้ Object ชื่อ birth
				customer.setAge(12); // set ชื่อ (name) ให้ Object ชื่อ age
				customer.setAddress("หัวเห็ด"); // set ชื่อ (name) ให้ Object ชื่อ address
				customer.setSubDistrict("บางนา"); // set ชื่อ (name) ให้ Object ชื่อ subDistrict
				customer.setDistrict("บางพลี"); // set ชื่อ (name) ให้ Object ชื่อ district
				customer.setTel("0215489547"); // set ชื่อ (name) ให้ Object ชื่อ tel
				customerRepository.save(customer); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("Cherprang").forEach(name -> {
				Customer customer = new Customer(); // สร้าง Object Customer
				customer.setCusName("namo tadsa"); // set ชื่อ (name) ให้ Object ชื่อ cusName
				customer.setIdentification("1457854125"); // set ชื่อ (name) ให้ Object ชื่อ idetification
				customer.setBirth(null);// set ชื่อ (name) ให้ Object ชื่อ birth
				customer.setAge(50); // set ชื่อ (name) ให้ Object ชื่อ age
				customer.setAddress("หัวเห็ด"); // set ชื่อ (name) ให้ Object ชื่อ address
				customer.setSubDistrict("บางนา"); // set ชื่อ (name) ให้ Object ชื่อ subDistrict
				customer.setDistrict("บางพลี"); // set ชื่อ (name) ให้ Object ชื่อ district
				customer.setTel("012454878"); // set ชื่อ (name) ให้ Object ชื่อ tel
				customerRepository.save(customer); // บันทึก Objcet ชื่อ Customer
			});

			clinichospitalRepository.save(new Clinichospital("โรงพยาบาล"));
			clinichospitalRepository.save(new Clinichospital("คลินิก"));

			hospitaltypeRepository.save(new Hospitaltype("สำนักงานสาธารณสุขจังหวัด"));
			hospitaltypeRepository.save(new Hospitaltype("สำนักงานสาธารณสุขอำเภอ"));
			hospitaltypeRepository.save(new Hospitaltype("โรงพยาบาลชุมชน"));
			hospitaltypeRepository.save(new Hospitaltype("โรงพยาบาลสังกัดกระทรวงอื่น"));
			hospitaltypeRepository.save(new Hospitaltype("โรงพยาบาลเอกชน"));

			insurancepackageRepository.save(new Insurancepackage("คุ้มครองการเสียชีวิตจากการเจ็บป่วยจากโรคภัยที่ร้ายแรง"));
            insurancepackageRepository.save(new Insurancepackage("คุ้มครองการเข้ารับการรักษาในฐานะผู้ป่วยในและนอก (IPD&OPD)"));
            insurancepackageRepository.save(new Insurancepackage("คุ้มครองการทุพพลภาพสิ้นเชิงถาวร"));
            insurancepackageRepository.save(new Insurancepackage("คุ้มครองอุบัติเหตุ การเสียชีวิต สายตา การรับฟังเสียง"));
            insurancepackageRepository.save(new Insurancepackage("คุ้มครองโรคเนื้องอก ซีสต์ มะเร็งระยะไม่ลุกลาม สูงสุด 3 แสนบาท"));
            insurancepackageRepository.save(new Insurancepackage("คุ้มครองโรคเกี่ยวกับโรคทางเดินหายใจ จากฝุ่นละอองและแก๊สพิษ สูงสุด 2 แสนบาท(ผู้ป่วยใน(IPD))"));
			insurancepackageRepository.save(new Insurancepackage("คุ้มครองโรคหลอดเลือดหัวใจ โรคกล้ามเนื้อหัวใจ โรคลิ้นหัวใจและโรคติดเชื้อบริเวณหัวใจ สูงสุด 2 แสนบาท(ผู้ป่วยใน(IPD))"));
			
			insurancetypeRepository.save(new Insurancetype("ประกันสุขภาพ"));
            insurancetypeRepository.save(new Insurancetype("ประกันอุบัติเหตุ"));
            insurancetypeRepository.save(new Insurancetype("ประกันโรคมะเร็ง"));
            insurancetypeRepository.save(new Insurancetype("ประกันโรคทางเดินหายใจ"));
			insurancetypeRepository.save(new Insurancetype("ประกันโรคหัวใจ"));
			
            paidtypeRepository.save(new Paidtype("จ่ายเฉพาะประกันสุขภาพแบบรายปี 20,000",20000));
			paidtypeRepository.save(new Paidtype("จ่ายแบบรายปี 15,000",15000));
			paidtypeRepository.save(new Paidtype("จ่ายแบบรายเดือน 500",500));

			branchRepository.save(new Branch("Nakhonrachasima"));
			branchRepository.save(new Branch("Surin"));
			branchRepository.save(new Branch("Bangkok"));

			headingRepository.save(new Heading("สอบถามข้อมูลเกี่ยวกับประกันชีวิต"));
			headingRepository.save(new Heading("สอบถามข้อมูลแพคเกจประกันสุขภาพ"));	
			headingRepository.save(new Heading("สอบถามข้อมูด้านการเคลมประกันสุขภาพ"));
			headingRepository.save(new Heading("ข้อมูลด้านสินเชื่อ"));
			headingRepository.save(new Heading("แจ้งเรื่องร้องเรียน"));
			headingRepository.save(new Heading("สอบถามเรื่องอื่นๆ"));

			contactRepository.save(new Contact("ติดต่อกลับทาง อีเมล"));
			contactRepository.save(new Contact("ติดต่อกลับทาง โทรศัพท์"));

			curebyRepository.save(new Cureby("ศัลยกรรม"));
			curebyRepository.save(new Cureby("ใช้ยา"));
			paychecksRepository.save(new Paychecks("ผู้เอาประกันภัย"));
			paychecksRepository.save(new Paychecks("ผู้เสียหาย"));
			paychecksRepository.save(new Paychecks("ตัวแทน"));
			paychecksRepository.save(new Paychecks("ตามที่อยู่ข้างต้น"));
			paychecksRepository.save(new Paychecks("บัญชี"));
			treatmethodRepository.save(new Treatmethod("เอ๊กซ์เรย์"));
			treatmethodRepository.save(new Treatmethod("ตรวจหัวใจ"));
			treatmethodRepository.save(new Treatmethod("ตรวจเลือด"));
			treatmethodRepository.save(new Treatmethod("ทำแผล"));
			
		
		};
	}
}
