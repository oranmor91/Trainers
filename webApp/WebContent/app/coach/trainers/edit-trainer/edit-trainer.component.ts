import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-trainer',
  templateUrl: './edit-trainer.component.html',
  styleUrls: ['./edit-trainer.component.css']
})
export class EditTrainerComponent implements OnInit {

  constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }

  userProgram(){
     this.router.navigate(['trainer-program']);
  }
}
