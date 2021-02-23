import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {LibraryService} from '../../../services/library.service'
import {FormGroup, FormControl, Validators } from '@angular/forms';
import { SimpleQuery, AdvancedQuery } from '../../../model/model';
import { saveAs as importedSaveAs } from 'file-saver';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchResult: Array<any>;
  allFields = ['title', 'author', 'content', 'genre'];
  operations = ['and', 'or'];

  querySearchForm = new FormGroup({
    query: new FormControl('education', [Validators.required]),
  });

  termSearchForm = new FormGroup({
    field: new FormControl('title'),
    value: new FormControl('', [Validators.required]),
  });

  booleanQuerySearchForm = new FormGroup({
    field1: new FormControl('title'),
    value1: new FormControl('', [Validators.required]),
    field2: new FormControl('title'),
    value2: new FormControl('', [Validators.required]),
    operation: new FormControl('and'),
  });

  constructor(private libraryService: LibraryService) {}

  ngOnInit(): void {
  }

  onQuerySearchFormSubmit(){
    var simpleQuery = new SimpleQuery(null, this.querySearchForm.get('query').value);

    this.libraryService.querySearch(simpleQuery)
      .subscribe((data) => {        
        this.searchResult = data["body"];
        console.log(this.searchResult);
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  onTermSearchFormSubmit(){
    var field = this.termSearchForm.get('field').value;
    var value = this.termSearchForm.get('value').value;
    var simpleQuery = new SimpleQuery(field, value);
    console.log(simpleQuery)
    
    this.libraryService.termSearch(simpleQuery)
      .subscribe((data) => {        
        this.searchResult = data["body"];
        console.log(this.searchResult);
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  onBooleanQuerySearchFormSubmit(){
    var field1 = this.booleanQuerySearchForm.get('field1').value;
    var value1 = this.booleanQuerySearchForm.get('value1').value;
    var field2 = this.booleanQuerySearchForm.get('field2').value;
    var value2 = this.booleanQuerySearchForm.get('value2').value;
    var operation = this.booleanQuerySearchForm.get('operation').value;

    var advancedQuery = new AdvancedQuery(field1, value1, field2, value2, operation);
    console.log(advancedQuery)

    this.libraryService.booleanQuerySearch(advancedQuery)
      .subscribe((data) => {        
        this.searchResult = data["body"];
        console.log(this.searchResult);
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  downloadPDF(internalId: string, title: string){
    this.libraryService.downloadPDF(internalId)
    .subscribe(
      (data: Blob) => {
        var file = new Blob([data], { type: 'application/pdf' })
        var fileURL = URL.createObjectURL(file);

    // if you want to open PDF in new tab
        //window.open(fileURL); 
        var a         = document.createElement('a');
        a.href        = fileURL; 
        a.target      = '_blank';
        a.download    = title + ".pdf";
        document.body.appendChild(a);
        a.click();
      },
      (error) => {
        console.log('getPDF error: ',error);
      }
    );
  }
}
