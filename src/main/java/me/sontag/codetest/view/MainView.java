package me.sontag.codetest.view;

import me.sontag.codetest.model.MainModel;
import me.sontag.codetest.model.Mortgage;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import me.sontag.codetest.model.Output;

/**
 *  Class for the webpage view
 *  Contains minimal logic
 */
@Route("")
public class MainView extends VerticalLayout {
    // Fields, grids, binders etc
    private TextField name = new TextField("Name");
    private NumberField monthlyInterest = new NumberField("Interest%/Month");
    private NumberField totalLoan = new NumberField("Total loan");
    private IntegerField payments = new IntegerField("Nr. of years");
    private Grid<Output> output = new Grid<>(Output.class);
    private Grid<Mortgage> grid = new Grid<>(Mortgage.class);
    private Binder<Mortgage> binder = new Binder<>(Mortgage.class);

    /**
     *  Constructor
     *  Inits and refreshes page since it may already have data to display
     */
    public MainView() {
        output.setColumns("output");
        grid.setColumns("name", "monthlyInterest", "totalLoan", "payments", "monthlyPayment");
        add(getInputForm(), output, grid);

        refreshGrids();
    }

    /**
     *  Create the input form and return it
     *  Sets up a basic layout and adds a listener that adds data to model
     *  @return Component representing the input form
     */
    private Component getInputForm() {
        var layout = new HorizontalLayout();

        var addButton = new Button("Add");
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.setAlignItems(Alignment.BASELINE);
        layout.add(name, monthlyInterest, totalLoan, payments, addButton);

        binder.bindInstanceFields(this);

        addButton.addClickListener(click -> {
           try {
               Mortgage mortage = new Mortgage();
               binder.writeBean(mortage);
               mortage.setMonthlyPayment();
               binder.readBean(new Mortgage());
               MainModel.getMortageList().add(mortage);
               MainModel.getOutput().add(new Output(mortage.toString()));
               refreshGrids();
           } catch(ValidationException e) {
               //
           }
        });

        return layout;
    }

    /**
     *  Method that refreshes grids by resetting their items
     */
    private void refreshGrids() {
        output.setItems(MainModel.getOutput());
        grid.setItems(MainModel.getMortageList());
    }

}
