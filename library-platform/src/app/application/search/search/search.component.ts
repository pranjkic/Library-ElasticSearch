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
    query: new FormControl('love'),
  });

  termSearchForm = new FormGroup({
    field: new FormControl('title'),
    value: new FormControl(''),
  });

  booleanQuerySearchForm = new FormGroup({
    field1: new FormControl('title'),
    value1: new FormControl(''),
    field2: new FormControl('title'),
    value2: new FormControl(''),
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

  download(filename: string, title: string){
    this.libraryService.download(filename).subscribe(blob => {
      importedSaveAs(blob, title);
    });
  }





  
  // public getSomething(): void{
  //    this.libraryService.getSomething()
  //   .subscribe((response) => {
  //       this.something = response['response'];
  //     },
  //     (error: HttpErrorResponse) => {
  //       alert(error.message)
  //       //console.log(error.message)
  //     }
  //   );
  // }

}
