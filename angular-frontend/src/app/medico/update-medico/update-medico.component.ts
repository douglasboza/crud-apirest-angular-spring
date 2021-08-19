import { Component, OnInit } from '@angular/core';
import { MedicoService } from '../../medico.service';
import { Medico } from '../../medico';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-medico',
  templateUrl: './update-medico.component.html',
  styleUrls: ['./update-medico.component.css']
})
export class UpdateMedicoComponent implements OnInit {

  id: number;
  medico: Medico = new Medico();
  constructor(public medicoService: MedicoService,
    public route: ActivatedRoute,
    public router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.medicoService.getMedicoById(this.id).subscribe(data => {
      this.medico = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.medicoService.updateMedico(this.id, this.medico).subscribe( data =>{
      this.goToMedicoList();
    }
    , error => console.log(error));
  }

  goToMedicoList(){
    this.router.navigate(['/medicos']);
  }
}