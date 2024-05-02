<?xml version="1.0" encoding="UTF-8"?>
<diagram>
    <class name="ChessPiece">
        <attributes>
            <attribute>- board: Board</attribute>
            <attribute>- color: Color</attribute>
        </attributes>
        <methods>
            <method>+ ChessPiece(board: Board, color: Color)</method>
            <method>+ getColor(): Color</method>
        </methods>
    </class>
    
    <class name="King">
        <inheritance>ChessPiece</inheritance>
        <methods>
            <method>+ King(board: Board, color: Color)</method>
            <method>+ toString(): String</method>
        </methods>
    </class>
    
    <class name="Rook">
        <inheritance>ChessPiece</inheritance>
        <methods>
            <method>+ Rook(board: Board, color: Color)</method>
            <method>+ toString(): String</method>
        </methods>
    </class>
    
    <class name="ChessMatch">
        <attributes>
            <attribute>- board: Board</attribute>
        </attributes>
        <methods>
            <method>+ ChessMatch()</method>
            <method>+ getPieces(): ChessPiece[][]</method>
            <method>+ placeNewPiece(column: char, row: int, piece: ChessPiece): void</method>
            <method>+ initialSetUp(): void</method>
        </methods>
    </class>
    
    <class name="UI">
        <methods>
            <method>+ printBoard(pieces: ChessPiece[][]): void</method>
            <method>+ printPiece(piece: ChessPiece): void</method>
        </methods>
    </class>
    
    <class name="Board">
        <attributes>
            <attribute>- rows: int</attribute>
            <attribute>- columns: int</attribute>
            <attribute>- pieces: Piece[][]</attribute>
        </attributes>
        <methods>
            <method>+ Board(rows: int, columns: int)</method>
            <method>+ getRows(): int</method>
            <method>+ getColumns(): int</method>
            <method>+ piece(row: int, column: int): Piece</method>
            <method>+ piece(position: Position): Piece</method>
            <method>+ placePiece(piece: Piece, position: Position): void</method>
            <method>+ positionExists(row: int, column: int): boolean</method>
            <method>+ positionExists(position: Position): boolean</method>
            <method>+ thereIsAPiece(position: Position): boolean</method>
        </methods>
    </class>
    
    <class name="BoardException">
        <methods>
            <method>+ BoardException(msg: String)</method>
        </methods>
    </class>
    
    <class name="Piece">
        <attributes>
            <attribute>- position: Position</attribute>
            <attribute>- board: Board</attribute>
        </attributes>
        <methods>
            <method>+ Piece(board: Board)</method>
            <method>+ getBoard(): Board</method>
        </methods>
    </class>
    
    <class name="Position">
        <attributes>
            <attribute>- row: int</attribute>
            <attribute>- column: int</attribute>
        </attributes>
        <methods>
            <method>+ Position(row: int, column: int)</method>
            <method>+ getRow(): int</method>
            <method>+ getColumn(): int</method>
            <method>+ toString(): String</method>
        </methods>
    </class>
    
    <class name="ChessPosition">
        <attributes>
            <attribute>- column: char</attribute>
            <attribute>- row: int</attribute>
        </attributes>
        <methods>
            <method>+ ChessPosition(column: char, row: int)</method>
            <method>+ getColumn(): char</method>
            <method>+ getRow(): int</method>
            <method>+ toPosition(): Position</method>
            <method>+ fromPosition(position: Position): ChessPosition</method>
            <method>+ toString(): String</method>
        </methods>
    </class>
</diagram>
