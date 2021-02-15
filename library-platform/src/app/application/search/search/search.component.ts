import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import {LibraryService} from '../../../services/library.service'

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private libraryService: LibraryService) { }

  ngOnInit(): void {
    console.log(this.libraryService.demoMethod())
  }

}
