import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators } from '@angular/forms';
//import { UploadModelBook } from '../../../model/model';
import {LibraryService} from '../../../services/library.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-indexing',
  templateUrl: './indexing.component.html',
  styleUrls: ['./indexing.component.css']
})
export class IndexingComponent implements OnInit {

  indexingForm = new FormGroup({
    title: new FormControl('', [Validators.required]),
    author: new FormControl('', [Validators.required]),
    genre: new FormControl('', [Validators.required]),
    ISBN: new FormControl('', [Validators.required]),
    keyWords: new FormControl('', [Validators.required]),
    publisher: new FormControl('', [Validators.required]),
    publishingYear: new FormControl('', [Validators.required]),
    publishingPlace: new FormControl('', [Validators.required]), 
    pageNumber: new FormControl('', [Validators.required]),    
    sysnopys: new FormControl('', [Validators.required]),       
    lectoringData: new FormControl('', [Validators.required]),
    directors: new FormControl('', [Validators.required]),        
    content: new FormControl('', [Validators.required]),
    file: new FormControl('', [Validators.required]),
    fileSource: new FormControl('', [Validators.required]),
  });

  constructor(private libraryService: LibraryService) { }

  ngOnInit(): void {
  }

  onSubmit(){    
    const formData = new FormData();
    formData.append('title', this.indexingForm.get('title').value);
    formData.append('author', this.indexingForm.get('author').value);
    formData.append('genre', this.indexingForm.get('genre').value);
    formData.append('ISBN', this.indexingForm.get('ISBN').value);
    formData.append('keywords', this.indexingForm.get('keyWords').value);
    formData.append('publisher', this.indexingForm.get('publisher').value);
    
    formData.append('pagenumber', this.indexingForm.get('pageNumber').value);
    formData.append('sysnopys', this.indexingForm.get('sysnopys').value);
    formData.append('lectoringdata', this.indexingForm.get('lectoringData').value);
    formData.append('publishingyear', this.indexingForm.get('publishingYear').value);
    formData.append('publishingplace', this.indexingForm.get('publishingPlace').value);
    formData.append('directors', this.indexingForm.get('directors').value);
    formData.append('content', this.indexingForm.get('content').value);
    formData.append('files', this.indexingForm.get('fileSource').value);   
    
    this.libraryService.indexBook(formData)
      .subscribe((data) => {
        console.log(data);
        alert("Successfully indexed!");
        this.indexingForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
    
  }

  onFileChange(event) {
    console.log('pozvato')
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      //console.log(file)
      this.indexingForm.patchValue({
        fileSource: file
      });
    }
  }

}