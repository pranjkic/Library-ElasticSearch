import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators } from '@angular/forms';
import { UploadModelBook } from '../../../model/model';
import {LibraryService} from '../../../services/library.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-indexing',
  templateUrl: './indexing.component.html',
  styleUrls: ['./indexing.component.css']
})
export class IndexingComponent implements OnInit {

  indexingForm = new FormGroup({
    title: new FormControl('title'),
    author: new FormControl('author'),
    genre: new FormControl('genre'),
    ISBN: new FormControl('isbn'),
    keyWords: new FormControl('kw'),
    publisher: new FormControl('publisher'),
    publishingYear: new FormControl('1995'),
    publishingPlace: new FormControl('srbija'), 
    pageNumber: new FormControl('55'),    
    sysnopys: new FormControl('syno'),       
    lectoringData: new FormControl('ld'),
    directors: new FormControl('director'),        
    content: new FormControl('content'),
  });

  constructor(private libraryService: LibraryService) { }

  ngOnInit(): void {
  }

  onSubmit(){

    var title = this.indexingForm.get('title').value
    var author = this.indexingForm.get('author').value
    var genre = this.indexingForm.get('genre').value
    var ISBN = this.indexingForm.get('ISBN').value
    var keyWords = this.indexingForm.get('keyWords').value
    var publisher = this.indexingForm.get('publisher').value
    var publishingYear = this.indexingForm.get('publishingYear').value
    var publishingPlace = this.indexingForm.get('publishingPlace').value
    var pageNumber = this.indexingForm.get('pageNumber').value
    var sysnopys = this.indexingForm.get('sysnopys').value
    var lectoringData = this.indexingForm.get('lectoringData').value
    var directors = this.indexingForm.get('directors').value
    var content = this.indexingForm.get('content').value

    var book = new UploadModelBook(title, author, genre, ISBN, keyWords, publisher, publishingYear,
                        publishingPlace, pageNumber, sysnopys, lectoringData, directors, content)

    this.libraryService.indexBook(book)
      .subscribe((data) => {
        console.log(data);
      },
      // (error: HttpErrorResponse) => {
      //   alert(error.message)
      // }
    );

    console.log("Submit")
  }

}