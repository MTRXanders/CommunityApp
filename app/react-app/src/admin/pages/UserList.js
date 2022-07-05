import { List, Datagrid, TextField} from "react-admin";

export const UserList = () => {
    <List>
        <Datagrid>
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="lastName"/>
            <TextField source="address"/>
            <TextField source="email"/>
            <TextField source="telephone"/>
            <TextField source="password"/>
        </Datagrid>
    </List>
}