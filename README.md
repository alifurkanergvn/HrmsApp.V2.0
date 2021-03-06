# HrmsApp.V2.0
 Human Resource Management System Updated

Req 1: Job Seekers should be able to register in the system.

Admission Criteria:

During registration, the user is asked for name, surname, tcno, year of birth, e-mail, password, password repetition information.
All fields are mandatory. The user is informed.
Registration in the system is performed by performing Mernis verification.
The user will be notified if the verification is not valid.
If there is a previously registered e-mail or TCNO, registration will not take place. The user is informed.
E-mail verification is required for registration to take place.
Req 2: Employers should be able to register in the system.

Admission Criteria:

During registration, the user is asked for e-mail, phone, password, password repetition information with the same domain as the company name, website, website. The goal here is to prevent non-companies from joining the system.
All fields are mandatory. The user is informed.
Company records are verified in two ways. E-mail verification is required for registration to take place. The approval of HRMS staff (our :)) is required.
If there is an email registered earlier, registration will not take place. The user is informed.
Req 3: General job position names should be added to the system. For example, Software Developer, Software Architect.

Admission Criteria:

These positions cannot be repeated. The user is alerted.
Req 4 : Employers should be able to be listed. (Only the whole list)

Req 5: Job seekers should be able to be listed. (Only the whole list)

Req 6 : Job positions should be able to be listed. (Only the whole list)

Important : These requirements are written without any backend-frontend distinction. (As in the industry). You should code the necessary parts for the backend.

Req 7: Employers should be able to add job postings to the system.

In the job posting form;
General job position can be selected from the dropdown list. (For example, Java Developer) (Required)
Job description entry should be possible. (For example, our company has command of languages ??????such as JAVA, C#, etc.....)(Required)
City information should be able to be selected from the drop-down list. (Compulsory)
It should be possible to enter min-max for the salary scale. (Optional)
It should be possible to enter the number of open positions. (Compulsory)
The application deadline must be entered.
Req 8: All active job postings in the system should be listed.

The list should come in tabular form.
Company name, general job position name, number of open positions, publication date, deadline should be in the list.
Req 9: All active job postings in the system should be listed by date.

The list should come in tabular form.
The company was on the list,
General job position name, number of open positions, publication date, deadline should be information.
Req 10: All active job postings of a company should be listed in the system.

The list should come in tabular form.
Company name, general job position name, number of open positions, publication date, deadline should be in the list.
Req 11 : Employers should be able to close a posting in the system. (Passive posting)



**********************************************************************************************************************************************************************************************************************************

Req 1 : ???? Arayanlar sisteme kay??t olabilmelidir.

Kabul Kriterleri:

Kay??t s??ras??nda kullan??c??dan ad, soyad, tcno, do??um y??l??, e-Posta, ??ifre, ??ifre tekrar?? bilgileri istenir.
T??m alanlar zorunludur. Kullan??c?? bilgilendirilir.
Mernis do??rulamas?? yap??larak sisteme kay??t ger??ekle??tirilir.
Do??rulama ge??erli de??ilse kullan??c?? bilgilendirilir.
Daha ??nce kay??tl?? bir e-posta veya tcno var ise kay??t ger??ekle??mez. Kullan??c?? bilgilendirilir.
Kay??d??n ger??ekle??mesi i??in e-posta do??rulamas?? gerekir.
Req 2 : ???? verenler sisteme kay??t olabilmelidir.

Kabul Kriterleri:

Kay??t s??ras??nda kullan??c??dan ??irket ad??, web sitesi, web sitesi ile ayn?? domaine sahip e-posta, telefon, ??ifre, ??ifre tekrar?? bilgileri istenir. Burada ama?? sisteme ??irket olmayanlar??n kat??lmas??n?? engellemektir.
T??m alanlar zorunludur. Kullan??c?? bilgilendirilir.
??irket kay??tlar?? iki ??ekilde do??rulan??r. Kay??d??n ger??ekle??mesi i??in e-posta do??rulamas?? gerekir. HRMS personelinin (bizim :)) onay?? gerekmektedir.
Daha ??nce kay??tl?? bir e-posta var ise kay??t ger??ekle??mez. Kullan??c?? bilgilendirilir.
Req 3 : Sisteme genel i?? pozisyonu isimleri eklenebilmelidir. ??rne??in Software Developer, Software Architect.

Kabul Kriterleri:

Bu pozisyonlar tekrar edemez. Kullan??c?? uyar??l??r.
Req 4 : ???? verenler listelenebilmelidir. (Sadece t??m liste)

Req 5 : ???? arayanlar listelenebilmelidir. (Sadece t??m liste)

Req 6 : ???? pozisyonlar?? listelenebilmelidir. (Sadece t??m liste)

??nemli : Bu isterler backend-frontend ay??r??m?? yap??lmaks??z??n yaz??lm????t??r. (Sekt??rdeki gibi). Siz backend i??in gerekli k??s??mlar?? kodlamal??s??n??z.

Req 7 : ???? verenler sisteme i?? ilan?? ekleyebilmelidir.

???? ilan?? formunda;
Se??ilebilir listeden (dropdown) genel i?? pozisyonu se??ilebilmelidir.(??rne??in Java Developer)(Zorunlu)
???? tan??m?? giri??i yap??labilmelidir. (??rne??in; firmam??z i??in JAVA, C# vb. dillere hakim....)(Zorunlu)
??ehir bilgisi a????l??r listeden se??ilebilmelidir. (Zorunlu)
Maa?? skalas?? i??in min-max giri??i yap??labilmelidir. (Opsiyonel)
A????k pozisyon adedi giri??i yap??labilmelidir. (Zorunlu)
Son ba??vuru tarihi giri??i yap??labilmelidir.

Req 8 : Sistemdeki t??m aktif i?? ilanlar?? listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmad??, genel i?? pozisyonu ad??, a????k pozisyon adedi, yay??n tarihi, son ba??vuru tarihi bilgileri olmal??d??r.

Req 9 : Sistemdeki t??m aktif i?? ilanlar?? tarihe g??re listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmad??, genel i?? pozisyonu ad??, a????k pozisyon adedi, yay??n tarihi, son ba??vuru tarihi bilgileri olmal??d??r.

Req 10 : Sistemde bir firmaya ait t??m aktif i?? ilanlar?? listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmad??, genel i?? pozisyonu ad??, a????k pozisyon adedi, yay??n tarihi, son ba??vuru tarihi bilgileri olmal??d??r.

Req 11 : ???? verenler sistemdeki bir ilan?? kapatabilmelidir. (Pasif ilan)


