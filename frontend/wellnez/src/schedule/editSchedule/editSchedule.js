import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import './editSchedule.css'; // Pastikan Anda mengimpor file CSS
import Navbar from '../../components/navbar/navbar';

const EditSchedule = ({ onClose, onSave }) => {
  // Hook untuk navigasi
  const navigate = useNavigate();
  
  // State untuk menyimpan data form
  const [scheduleData, setScheduleData] = useState({
    name: '',
    description: '',
    dateTime: '', // Akan menyimpan gabungan tanggal dan waktu
    type: ''
  });

  // Handler untuk memperbarui state saat input berubah
  const handleChange = (e) => {
    const { name, value } = e.target;
    setScheduleData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  // Handler untuk tombol "OK"
  const handleOk = () => {
    // Di sini Anda bisa menambahkan validasi data
    if (scheduleData.name && scheduleData.description && scheduleData.dateTime && scheduleData.type) {
      // Panggil fungsi onSave yang akan mengirim data ke parent component/API
      onSave(scheduleData);
      // Tutup modal (ini mungkin perlu dihapus/disesuaikan jika AddSchedule bukan modal)
      // onClose(); 
    } else {
      alert('Semua field harus diisi!');
    }
  };

  // Handler untuk tombol "Cancel"
  const handleCancel = () => {
    // Navigasi ke route /schedule
    navigate('/schedule'); 
    // Tutup modal jika komponen ini digunakan sebagai modal
    // onClose(); 
  };

  return (
    <div className='addwraper'>

    <Navbar />
    {/* Mengubah add-schedule-modal-overlay menjadi container atau menghapusnya jika ini bukan modal, 
        tapi saya tetap mempertahankannya sesuai struktur yang ada */}
    <div className="add-schedule-modal-overlay" onClick={onClose}>
      {/* Modal Content - hentikan klik menyebar ke overlay */}
      <div className="add-schedule-modal-content" onClick={e => e.stopPropagation()}>
        
        {/* Header */}
        <h2 className="modal-title">Edit Schedule</h2>
        
        {/* Form Inputs */}
        <div className="modal-form-group">
          <input
            type="text"
            name="name"
            placeholder="Schedule Name"
            value={scheduleData.name}
            onChange={handleChange}
            className="modal-input"
          />
        </div>

        <div className="modal-form-group">
          <input
            type="text"
            name="description"
            placeholder="Schedule Description"
            value={scheduleData.description}
            onChange={handleChange}
            className="modal-input"
          />
        </div>

        <div className="modal-form-group date-time-input-container">
          {/* Input Tanggal dan Waktu - gunakan type datetime-local untuk kemudahan */}
          <input
            type="datetime-local"
            name="dateTime"
            value={scheduleData.dateTime}
            onChange={handleChange}
            className="modal-input date-time-input"
          />
          {/* Untuk tampilan placeholder dd/mm/yyyy --:-- seperti di gambar, 
                Anda mungkin perlu library date picker atau membuatnya secara manual 
                dengan input terpisah (date dan time) dan icon kalender. 
                Menggunakan datetime-local adalah cara modern yang lebih mudah.
                Saya akan tetap membuat styling-nya mirip.
          */}
        </div>

        <div className="modal-form-group">
          <input
            type="text"
            name="type"
            placeholder="Schedule Type"
            value={scheduleData.type}
            onChange={handleChange}
            className="modal-input"
          />
        </div>
        
        {/* Container untuk Tombol OK dan Cancel */}
        <div className="button-container"> 
            {/* Cancel Button (Merah) */}
            <button 
                onClick={handleCancel} 
                className="modal-cancel-button"
            >
                Cancel
            </button>
            
            {/* OK Button (Hijau) */}
            <button 
                onClick={handleOk} 
                className="modal-ok-button"
            >
                OK
            </button>
        </div>
        

      </div>
    </div>
    </div>
  );
};

export default EditSchedule;